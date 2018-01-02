package com.bpzj.web.domain;

public class Student {

    private Long id;
    private Long createAt;
    private Long updateAt;
    private String name;
    private String qq;
    private Integer type;
    private String entryTime;
    private String school;
    private Integer studentId;
    private String link;
    private String oath;
    private String brother;
    private String knowfrom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime == null ? null : entryTime.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath == null ? null : oath.trim();
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother == null ? null : brother.trim();
    }

    public String getKnowfrom() {
        return knowfrom;
    }

    public void setKnowfrom(String knowfrom) {
        this.knowfrom = knowfrom == null ? null : knowfrom.trim();
    }

    public Student(Long id, String name, String qq, Integer type, String entryTime, String school, Integer studentId, String link, String oath, String brother, String knowfrom) {
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
        this.knowfrom = knowfrom;
    }

    public Student(String name, String qq, int type, String entryTime, String school,  String oath, String knowFrom) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.entryTime = entryTime;
        this.school = school;
        this.oath = oath;
        this.knowfrom = knowFrom;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type=" + type +
                ", entryTime='" + entryTime + '\'' +
                ", school='" + school + '\'' +
                ", studentId=" + studentId +
                ", link='" + link + '\'' +
                ", oath='" + oath + '\'' +
                ", brother='" + brother + '\'' +
                ", knowfrom='" + knowfrom + '\'' +
                '}';
    }
}