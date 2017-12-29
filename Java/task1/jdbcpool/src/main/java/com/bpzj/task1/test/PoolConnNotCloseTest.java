package com.bpzj.task1.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoolConnNotCloseTest {
    /*
    * 连接池，连接不关闭，循环测试*/

    public static void main(String[] args){
        ComboPooledDataSource cd = new ComboPooledDataSource();
        try {
            for (int i = 0; i < 1000; i++) {
                Connection connection = cd.getConnection();
                String sql = "INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1,'11月18日-22日'," +
                        "'燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
