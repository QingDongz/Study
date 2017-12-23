import com.bpzj.jdbcTemplate.task1.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuote {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

    }
}
