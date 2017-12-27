package com.bpzj.log4j2Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lo4j2Test {

    // 1. 基于类的名称获取日志对象
    static Logger logger = LogManager.getLogger(lo4j2Test.class.getName());
    public static void main(String[] args) throws InterruptedException {

        //4. 进行不同级别的日志输出
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");

    }
}
