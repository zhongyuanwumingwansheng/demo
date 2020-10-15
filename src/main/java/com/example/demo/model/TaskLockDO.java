package com.example.demo.model;

import java.util.Date;

public class TaskLockDO {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String projectName;

    private String tableName;

    private String partition;

    private Long recordBegin;

    private Long recordEnd;

    private Boolean locked;

    private Boolean finisded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public Long getRecordBegin() {
        return recordBegin;
    }

    public void setRecordBegin(Long recordBegin) {
        this.recordBegin = recordBegin;
    }

    public Long getRecordEnd() {
        return recordEnd;
    }

    public void setRecordEnd(Long recordEnd) {
        this.recordEnd = recordEnd;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getFinisded() {
        return finisded;
    }

    public void setFinisded(Boolean finisded) {
        this.finisded = finisded;
    }
}
