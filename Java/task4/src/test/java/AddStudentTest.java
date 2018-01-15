import com.bpzj.task4.dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

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
        for (int i=0;i<5;i++) {
            Integer uuid = UUID.randomUUID().;

        }

    }

}
