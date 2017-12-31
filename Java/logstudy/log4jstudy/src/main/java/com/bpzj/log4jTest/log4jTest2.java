package com.bpzj.log4jTest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4jTest2 {
    static Logger logger = Logger.getLogger(log4jTest2.class);

    public static void main(String[] args) {

        // 指定配置文件的写法
        // PropertyConfigurator.configure("E:\\OneDrive\\Code - java\\Task1\\log4jTest\\src\\main\\resources\\log4j.properties");

        // 2. 进行默认配置
        BasicConfigurator.configure();
        //3. 设置日志输出级别
        logger.setLevel(Level.TRACE);

        for (int i=0;i<20; i++) {
            System.out.println(i);
        }

    }
}
