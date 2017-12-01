package com.mathpar.web.db.entity;

public class Subject {

    private long id;
    private long teacherId;
    private String subjectName;

    public Subject() {
    }

    public Subject(long id, long teacherId, String subjectName) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
