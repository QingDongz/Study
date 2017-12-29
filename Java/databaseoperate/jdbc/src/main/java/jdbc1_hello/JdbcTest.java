package jdbc1_hello;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        try {
            // 初始化驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");

            // 建立与数据库的Connection连接
            // java.sql.Connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sign_up?characterEncoding=utf8&useSSL=true",
                    "root",
                    "zhwy");

            System.out.println("连接成功，获取连接对象： " + conn);

            // Statement是用于执行SQL语句的, 创建Statement
            statement = conn.createStatement();
            String sql = "INSERT INTO student VALUES(NULL, NOW(), NOW(),?,?,?,?,?,?,?,?,?,?)";
            statement.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}

