package com.bpzj.task4.domain;

public class Job {
    private Integer id;

    private Integer jobId;

    private String jobName;

    private String introduce;

    private Integer entryBarrier;

    private Integer difficultLevel;

    private String growTime;

    private Integer firmRequiredNum;

    private String salary1;

    private String salary2;

    private String salary3;

    private String tips;

    private Long createAt;

    private Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getEntryBarrier() {
        return entryBarrier;
    }

    public void setEntryBarrier(Integer entryBarrier) {
        this.entryBarrier = entryBarrier;
    }

    public Integer getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(Integer difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    public String getGrowTime() {
        return growTime;
    }

    public void setGrowTime(String growTime) {
        this.growTime = growTime == null ? null : growTime.trim();
    }

    public Integer getFirmRequiredNum() {
        return firmRequiredNum;
    }

    public void setFirmRequiredNum(Integer firmRequiredNum) {
        this.firmRequiredNum = firmRequiredNum;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1 == null ? null : salary1.trim();
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2 == null ? null : salary2.trim();
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3 == null ? null : salary3.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
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