package com.bpzj.SMUseXML;

import java.io.Serializable;

public class Student implements Serializable {
    private long id;
    private long createAt;
    private long updateAt;
    private String name;
    private String qq;
    private int type;
    private String entryTime;
    private String school;
    private String studentId;
    private String link;
    private String oath;
    private String brother;
    private String knowFrom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    @Override
    public String toString() {
        return "Student [" +
                "id=" + id +
                ", creatAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type=" + type +
                ", entryTime='" + entryTime + '\'' +
                ", school='" + school + '\'' +
                ", studentId='" + studentId + '\'' +
                ", link='" + link + '\'' +
                ", oath='" + oath + '\'' +
                ", brother='" + brother + '\'' +
                ", knowFrom='" + knowFrom + '\'' +
                ']';
    }

    public Student(long id, String name, String qq, int type, String entryTime, String school, String studentId, String link, String oath, String brother, String knowFrom) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.entryTime = entryTime;
        this.school = school;
        this.studentId = studentId;
        this.link = link;
        this.oath = oath;
        this.brother = brother;
        this.knowFrom = knowFrom;
    }

    public Student() {
        super();
    }

}
