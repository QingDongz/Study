import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestDataSource {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-jdbc.xml");
        
//        DataSource datasource = (DataSource) ctx.getBean("dataSource");
//        System.out.println(datasource.getConnection());
//
//        DataSource datasource2 = (DataSource) ctx.getBean("dataSource2");
//        System.out.println(datasource2.getConnection());

        DataSource datasource4 = (DataSource) ctx.getBean("dataSource4");
        System.out.println(datasource4.getConnection());
    }
}
