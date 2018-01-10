import com.bpzj.web.dao.StudentMapper;
import com.bpzj.web.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*
 * 测试mybatis 反向工程生成的Mapper*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    StudentMapper studentMapper;

    // 这个 sqlSession 需要在 applicationContext.xml 配置，是mybatis的SqlSession类型
    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {


//        studentMapper.insertSelective(new Student("ssm1","12345",1,"1月1日",
//                "新年好","兄弟","天下"));

        // 插入1000条数据，这里用到了sqlSession 生成 Mapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        for (int i = 0; i<1000;i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            studentMapper.insertSelective(new Student(uid,"12345",1,"1月1日",
                    "新年好","兄弟","天下"));
        }
    }

}