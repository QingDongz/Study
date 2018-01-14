import com.bpzj.jdbctemplate.task1.House;
import com.bpzj.jdbctemplate.task1.User;
import com.bpzj.jdbctemplate.task1.UserController;
import com.bpzj.jdbctemplate.task1.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAnnotation {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

        House house = (House) ctx.getBean("house");
        System.out.println(house);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        User user = (User) ctx.getBean("userImpl");
        System.out.println(user);

        // 通过另外的方法getBean，因为有两个 类实现了接口：UserImpl和UserConfuse，下面这个会报错。
        User user1 = ctx.getBean(User.class);
        System.out.println(user1);
    }
}
