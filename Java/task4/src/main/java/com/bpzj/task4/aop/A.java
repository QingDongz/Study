package com.bpzj.task4.aop;

public class A {

    Long value = new Long(4566);
    // Long转化为String：
    String string = "" + value;
    // String转化为Long：
    long aLong = Long.parseLong(string);
}
