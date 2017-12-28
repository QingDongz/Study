import com.bpzj.SMUseXML.Student;
import com.bpzj.SMUseXML.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUseSpringTest {

    @Autowired
    public StudentDao studentDao;

    //查
    @Test
    public void findAll() {
        System.out.println(studentDao);
        List<Student> students =studentDao.listAll();
        for (Student student : students) {
            System.out.println(student);
        }
//        studentDao.deleteById(1);
    }
}
