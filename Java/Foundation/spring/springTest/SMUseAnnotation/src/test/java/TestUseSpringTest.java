import com.bpzj.SMUseAnnotation.Student;
import com.bpzj.SMUseAnnotation.StudentDao;
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

    public Student newStudent() {
        Student student= new Student(1,"新名","12345",1,"明天",
                "清华","1234","http://www.jnshu.com/occupation/5/daily",
                "新年好","兄弟","天下");
        return student;
    }

    //增
    @Test
    public void add() {
        Student student1 = newStudent();
        student1.setId(1);
        boolean a= studentDao.add(student1);
        if (a) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //删
    @Test
    public void delete() {
        boolean a= studentDao.deleteById(1);
        if (a) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //改
    @Test
    public void update() {
        Student student1 = newStudent();
        student1.setId(2);
        student1.setOath("老大最帅");
        boolean a= studentDao.updateById(student1);
        if (a) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    //查
    @Test
    public void findAll() {
        System.out.println(studentDao);
        List<Student> students =studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
