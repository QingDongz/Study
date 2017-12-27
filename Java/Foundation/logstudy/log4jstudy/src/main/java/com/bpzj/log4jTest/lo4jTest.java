package com.bpzj.log4jTest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class lo4jTest {

    // 1. 基于类的名称获取日志对象
    static Logger logger = Logger.getLogger(lo4jTest.class);
    public static void main(String[] args) throws InterruptedException {

        //2. 进行默认配置
        BasicConfigurator.configure();

        //3. 设置日志输出级别
        logger.setLevel(Level.TRACE);

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
