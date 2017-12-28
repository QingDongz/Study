import com.bpzj.jdbctemplate.task1.House;
import com.bpzj.jdbctemplate.task1.User;
import com.bpzj.jdbctemplate.task1.UserController;
import com.bpzj.jdbctemplate.task1.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInclude {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("include-filter.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        House house = (House) ctx.getBean("house");
        System.out.println(house);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);


        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }
}
