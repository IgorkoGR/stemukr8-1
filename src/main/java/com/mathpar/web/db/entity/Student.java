package com.mathpar.web.db.entity;

public class Student {

    public long id;
    public long userId;
    public long groupId;

    public Student() {
    }

    public Student(long id, long userId, long groupId) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
