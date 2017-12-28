import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InterruptTest {

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
        String sql = "INSERT INTO student VALUES(null, NOW(), NOW(),?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sign_up?characterEncoding=UTF-8&useSSL=true",
                "root", "zhwy");
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1,"曲艳行");
            ps.setString(2,"3169119846");
            ps.setInt(3, 1);
            ps.setString(4,"11月18日-22日");
            ps.setString(5,"燕山大学");
            ps.setInt(6,2641);
            ps.setString(7,"http://www.jnshu.com/daily/");
            ps.setString(8,"老大最帅");
            ps.setString(9,"郑州分院王鹏举");
            ps.setString(10,"知乎");
            for (int i=0;i<1000;i++) {
                // 测试中断数据库连接
                // conn.close();

                ps.execute();
            }
            // ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("failure");
        }
    }


}
