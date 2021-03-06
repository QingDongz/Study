package com.bpzj.task1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionInterruptTest {
    // 这里就可以关闭连接了
    public static void main(String[] args) {
        // 使用关闭流的写法
        // 初始化驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 初始化驱动
        String sql = "INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1,'11月18日-22日'," +
                "'燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sign_up?characterEncoding=UTF-8&useSSL=true",
                "root", "zhwy");
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            for (int i = 0; i < 1000; i++) {
                // 测试中断数据库连接
                conn.close();
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
        }
    }
}
