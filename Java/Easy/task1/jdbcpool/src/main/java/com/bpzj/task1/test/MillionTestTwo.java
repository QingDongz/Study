package com.bpzj.task1.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class MillionTestTwo {

    public static void main(String[] args) throws SQLException {
        Long begin = new Date().getTime();
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
        Connection connection = pooledDataSource.getConnection();

        for (int i = 0; i < 20; i++) {
            // String类是字符串常量，不可更改。 而StringBuffer是变量，可以扩充和修改的。
            StringBuffer sql = new StringBuffer("INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1," +
                    "'11月18日-22日','燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')");
            String add = ",(null, NOW(), NOW(),'曲艳行','3169119846',1,'11月18日-22日','燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";
            String sqlAdded = addStringRepeatTimes(sql, add, 5000);

            // PreparedStatement有预编译机制，性能比Statement更快
            PreparedStatement ps = connection.prepareStatement(sqlAdded);
            // executeUpdate返回的是int，表示有多少条数据受到了影响; executeUpdate不能执行查询语句
            ps.executeUpdate();
            ps.close();
        }
        Long end = new Date().getTime();
        System.out.println("cost : " + (end - begin) / 1000 + " s");
    }



    private static String addStringRepeatTimes(StringBuffer stringBuffer, String string , long repeatTimes) {
        for (long time = 0; time<repeatTimes; time++) {
            stringBuffer.append(string);
        }
        String addedString = stringBuffer.toString();
        return addedString;
    }

}

