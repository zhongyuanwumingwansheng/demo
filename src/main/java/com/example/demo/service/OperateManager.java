package com.example.demo.service;

import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 */
public class OperateManager {


    public TransactionTemplate transactionTemplate;

    public void lock(String projectName, String tableName, String partition){
        transactionTemplate.execute(action ->{
            //搜索还未finish的作业
            //对于还未finished的作业，查看是否为lock

            return null;
        });
    }
}
