import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionPoolTest {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        // 循环一千次
        for (int i = 1; i < 200; i++) {
            System.out.println(i);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("数据库驱动加载成功 ！");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try{ conn = DriverManager .getConnection(
                    "jdbc:mysql://localhost:3306/sign_up?characterEncoding=utf8&useSSL=true",
                    "root",
                    "zhwy");
                conn.setAutoCommit(false);

                String sql = "INSERT INTO student VALUES(NULL, NOW(), NOW(),?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,"曲艳行");
                preparedStatement.setString(2,"3169119846");
                preparedStatement.setInt(3, 1);
                preparedStatement.setString(4,"11月18日-22日");
                preparedStatement.setString(5,"燕山大学");
                preparedStatement.setInt(6,2641);
                preparedStatement.setString(7,"http://www.jnshu.com/daily/");
                preparedStatement.setString(8,"老大最帅");
                preparedStatement.setString(9,"郑州分院王鹏举");
                preparedStatement.setString(10,"知乎");
                preparedStatement.execute();
                conn.commit();

                // 测试这里，不惯闭数据库连接试试，这里正常写法应该判断，
                // 先关闭Statement，后关闭Connection，为空就关闭
                // conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}