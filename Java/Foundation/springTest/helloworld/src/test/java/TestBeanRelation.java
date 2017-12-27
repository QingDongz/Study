import com.bpzj.jdbcTemplate.task1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanRelation {
    public static void main(String[] args) {

        //创建 spring 的 ioc 对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");

        //从ioc容器获bean对象


        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);


    }
}
