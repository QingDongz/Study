import com.bpzj.task4.dao.StudentMapper;
import com.bpzj.task4.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddStudentTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void addStudent() {
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        for (int i = 8; i < 10; i++) {
            Date date = new Date();
            Long createTime = date.getTime();
            Student student = new Student
                    (i, "罗大佑", 1, "一声梧叶一声秋", i % 2, i % 2, createTime, createTime);
            studentMapper.insertSelective(student);
        }

    }

}
