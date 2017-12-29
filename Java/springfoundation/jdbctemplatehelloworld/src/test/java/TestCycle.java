import com.bpzj.jdbctemplate.task1.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
    public static void main(String[] args) {
        System.out.println("新建容器之前");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycles.xml");
        System.out.println("新建容器之后");

        System.out.println("getBean之前");
        Car car = (Car) ctx.getBean("car");
        System.out.println("getBean之后");

        System.out.println(car);

        ctx.close();
    }
}
