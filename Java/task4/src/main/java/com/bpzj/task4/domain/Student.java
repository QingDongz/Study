package com.bpzj.task4.domain;

public class Student {
    private Integer id;

    private String name;

    private Integer jobId;

    private String briefIntroduce;

    private Integer isStudying;

    private Integer isExcellent;

    private Long createAt;

    private Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getBriefIntroduce() {
        return briefIntroduce;
    }

    public void setBriefIntroduce(String briefIntroduce) {
        this.briefIntroduce = briefIntroduce == null ? null : briefIntroduce.trim();
    }

    public Integer getIsStudying() {
        return isStudying;
    }

    public void setIsStudying(Integer isStudying) {
        this.isStudying = isStudying;
    }

    public Integer getIsExcellent() {
        return isExcellent;
    }

    public void setIsExcellent(Integer isExcellent) {
        this.isExcellent = isExcellent;
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

    public Student(Integer id, String name, Integer jobId, String briefIntroduce, Integer isStudying, Integer isExcellent) {
        this.id = id;
        this.name = name;
        this.jobId = jobId;
        this.briefIntroduce = briefIntroduce;
        this.isStudying = isStudying;
        this.isExcellent = isExcellent;
    }

    public Student() {
    }
}