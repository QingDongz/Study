package com.bpzj.mybaitsOld;

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

    /*
    * 不需要提供 getter 和 setter 方法，mybatis
    * 就可以自动把数据映射到对象上*/

    @Override
    public String toString() {
        return "Student [" +
                "id=" + id +
                ", createAt=" + createAt +
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

}
