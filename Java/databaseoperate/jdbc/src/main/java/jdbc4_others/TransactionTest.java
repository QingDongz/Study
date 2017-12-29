package jdbc4_others;

import java.sql.*;

public class TransactionTest {

    public static void main(String[] args) throws SQLException {

        // 初始化驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO student VALUES(NULL, NOW(), NOW(),?,?,?,?,?,?,?,?,?,?)";
        // 使用流，自动关闭，放在 try(){} 的() 中的对象，自动关闭。
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sign_up?characterEncoding=utf8&useSSL=true",
                "root",
                "zhwy");
             PreparedStatement ps = conn.prepareStatement(sql);
        )
        {
            // 事务开始
            conn.setAutoCommit(false);
            ps.execute();

            // 提交事务
            conn.commit();
        }
    }
}
