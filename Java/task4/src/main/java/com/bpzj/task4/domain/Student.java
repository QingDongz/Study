package com.bpzj.task4.domain;

public class Student {
    private Integer uuid;

    private String name;

    private Integer studyCondition;

    private Integer jobId;

    private String briefIntroduce;

    private Integer isExcellent;

    private Long createAt;

    private Long updateAt;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStudyCondition() {
        return studyCondition;
    }

    public void setStudyCondition(Integer studyCondition) {
        this.studyCondition = studyCondition;
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
}