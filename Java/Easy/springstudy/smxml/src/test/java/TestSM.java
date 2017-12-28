import com.bpzj.SMUseXML.Student;
import com.bpzj.SMUseXML.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestSM {

    //查
    @Test
    public void findAll() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        List<Student> students =studentDao.listAll();
        for (Student student : students) {
            System.out.println(student);
        }
        studentDao.deleteById(1);
    }
}