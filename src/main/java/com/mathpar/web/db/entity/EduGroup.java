package com.mathpar.web.db.entity;

public class EduGroup {

    public long id;
    public String groupName;

    public EduGroup() {
    }

    public EduGroup(long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
