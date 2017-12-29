package jdbc1_hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestAutoClose {

    public static void main(String[] args) throws SQLException {

        // 初始化驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 使用流，自动关闭，放在 try(){} 的() 中的对象，自动关闭。
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sign_up?characterEncoding=utf8&useSSL=true",
                "root",
                "zhwy");
             Statement statement = conn.createStatement();
        )
        {
            System.out.println("连接成功，获取连接对象： " + conn);
            // Statement是用于执行SQL语句的, 创建Statement
            String sql = "INSERT INTO student VALUES(NULL, NOW(), NOW(),?,?,?,?,?,?,?,?,?,?)";
            statement.execute(sql);
        }
    }
}
