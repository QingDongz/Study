import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0PoolTest {

    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource cd = new ComboPooledDataSource();
        String sql = "INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1,'11月18日-22日'," +
                "'燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";

        try (Connection connection = cd.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             )
        {
            ps.executeUpdate();
        }
    }

}
