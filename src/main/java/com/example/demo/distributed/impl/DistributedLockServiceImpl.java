package com.example.demo.distributed.impl;

import com.example.demo.dao.LockDAO;
import com.example.demo.distributed.DistributedLockService;
import com.example.demo.model.LockDO;
import com.example.demo.util.LocalIpAddressUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.UUID;

public class DistributedLockServiceImpl implements DistributedLockService {

    @Autowired
    private LockDAO lockDAO;

    /**
     * 尝试获取锁，可重入锁
     * @param lockName
     * @return
     */
    @Override
    public Boolean tryAcquire(String lockName){
        String hostName = LocalIpAddressUtil.getHostAddress();
        String threadName = Thread.currentThread().getName();
        return acquire(lockName, hostName, threadName);
    }

    /**
     * 尝试释放锁，可重入锁
     * @param lockName
     * @return
     */
    @Override
    public Boolean tryRelease(String lockName){
        String hostName = LocalIpAddressUtil.getHostAddress();
        String threadName = Thread.currentThread().getName();
        return release(lockName, hostName, threadName);
    }

    /**
     * 尝试获取锁，不可重入锁，内部通过控制uniqueKey的唯一性来控制不可重入
     * @param lockName
     * @return
     */
    @Override
    public String tryAcquireUnReentrant(String lockName){
        return tryAcquireUnReentrant(lockName, null);
    }

    /**
     * 尝试获取锁，不可重入锁
     * @param lockName
     * @param uniqueKey
     * @return
     */
    @Override
    public String tryAcquireUnReentrant(String lockName, String uniqueKey){
        if(StringUtils.isBlank(uniqueKey)){
            uniqueKey = generateUnique();
        }
        String hostName = LocalIpAddressUtil.getHostAddress();
        String threadName = Thread.currentThread().getName()+"_"+uniqueKey;
        Boolean acquire = acquire(lockName, hostName, threadName);
        //TODO,打日志
        return acquire ? uniqueKey:null;
    }

    /**
     * 尝试释放锁，不可重入锁
     * @param lockName
     * @param uniqueKey
     * @return
     */
    @Override
    public Boolean tryReleaseUnReentrant(String lockName, String uniqueKey){
        if(StringUtils.isBlank(uniqueKey)){
            return false;
        }
        String hostName = LocalIpAddressUtil.getHostAddress();
        String threadName = Thread.currentThread().getName()+"_"+uniqueKey;
        Boolean ret = release(lockName, hostName, threadName);
        //TODO,打日志
        return ret;
    }

    /**
     *
     * @param lockName
     * @param hostName
     * @param threadName
     * @return
     */
    private Boolean acquire(String lockName, String hostName, String threadName){
        String host = hostName+"_"+threadName;
        LockDO lock = lockDAO.findLockByName(lockName);
        if(isLockedByOthers(lock, host)){
            return false;
        } else {
            // TODO，从动态配置里面读取
            int expireMinutes = 100;
            if(null == lock){
                LockDO lockNew = new LockDO();
                lockNew.setLockHost(host);
                lockNew.setLockName(lockName);
                lockNew.setCreateTime(new Date());
                lockNew.setLockVersion(0);
                Date expired = DateUtils.addMinutes(new Date(), expireMinutes);
                lockNew.setExpiredTime(expired);

                Boolean insert =lockDAO.insert(lockNew);
                if(!insert){
                    return false;
                }
            } else if(host.equalsIgnoreCase(lock.getLockHost())){
                //重入
                Date expired = DateUtils.addMinutes(new Date(),expireMinutes);
                lock.setExpiredTime(expired);
                Boolean update = lockDAO.update(lock);
                if(!update){
                    return false;
                }
            } else if((new Date()).after(lock.getExpiredTime())){
                //超时
                lock.setLockHost(host);
                Date expired = DateUtils.addMinutes(new Date(), expireMinutes);
                lock.setExpiredTime(expired);
                Boolean update = lockDAO.update(lock);
                if(!update){
                    return false;
                }
            }

            lock = lockDAO.findLockByName(lockName);
            if(isLockedByOthers(lock, host)){
                return false;
            }
            return true;
        }


    }

    private Boolean release(String lockName, String hostName, String threadName){
        LockDO lock = new LockDO();
        lock.setLockName(lockName);
        String host = hostName+"_"+threadName;
        lock.setLockHost(host);
        return lockDAO.delete(lock);
    }

    private boolean isLockedByOthers(LockDO lock, String host){
        //第一次进入
        if(null == lock){
            return false;
        } else {
            if(host.equalsIgnoreCase(lock.getLockHost())){
                return false;
            }else {
                //判断是否达到超期时间
                return !(new Date()).after(lock.getExpiredTime());
            }
        }
    }

    private String generateUnique(){
        return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }
}
