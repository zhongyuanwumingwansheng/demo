package com.example.demo.distributed;

public interface DistributedLockService {
    /**
     * 尝试获取锁，可重入锁
     * @param lockName
     * @return
     */
    Boolean tryAcquire(String lockName);

    /**
     * 尝试释放锁，可重入锁
     * @param lockName
     * @return
     */
    Boolean tryRelease(String lockName);

    /**
     * 尝试获取锁，不可重入锁，内部通过控制uniqueKey的唯一性来控制不可重入
     * @param lockName
     * @return
     */
    String tryAcquireUnReentrant(String lockName);

    /**
     * 尝试获取锁，不可重入锁
     * @param lockName
     * @param uniqueKey
     * @return
     */
    String tryAcquireUnReentrant(String lockName, String uniqueKey);

    /**
     * 尝试释放锁，不可重入锁
     * @param lockName
     * @param uniqueKey
     * @return
     */
    Boolean tryReleaseUnReentrant(String lockName, String uniqueKey);
}