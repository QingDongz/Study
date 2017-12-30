package com.bpzj.task1.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Log4jTest {

    public static void main(String[] args) throws SQLException{
        Long begin = new Date().getTime();
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
        Connection connection = pooledDataSource.getConnection();

        String sql = "INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1," +
                    "'11月18日-22日','燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";

        // PreparedStatement有预编译机制，性能比Statement更快
        PreparedStatement ps = connection.prepareStatement(sql);
        // executeUpdate返回的是int，表示有多少条数据受到了影响; executeUpdate不能执行查询语句
        ps.executeUpdate();
        ps.close();

        Long end = new Date().getTime();
        System.out.println("插入数据需要时间 : " + (end - begin)  + " ms");
    }
}
