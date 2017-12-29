import com.bpzj.mybatisNew.dao.StudentDao;
import com.bpzj.mybatisNew.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUseXML {
    // 先定义，下面用SqlSessionFactoryBuilder 创建 SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    // 先定义，再用 SqlSessionFactory.openSession 获得 SqlSession
    private SqlSession sqlSession;

    // 先定义，再用 sqlSession.getMapper 生成 接口 的代理对象
    private StudentDao studentDao;


    @Before
    public void before() throws IOException{

        InputStream inputStream = Resources.getResourceAsStream("mybatisUseXML.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    // 增
    @Test
    public void addStudent() {

        Student student= new Student(6,"新名","12345",1,"明天","清华",
                "1234","http:hello","新年好","兄弟","天下");

        studentDao.add(student);
        sqlSession.commit();
    }

    //改
    @Test
    public void update() {

        Student student= new Student(1,"新名","12345",1,"明天","清华",
                "1234","http:hello","新年好","兄弟","天下");

        student.setId(4);
        student.setName("mybatis更改");
        studentDao.updateById(student);
        sqlSession.commit();
    }

    // 删
    @Test
    public void delete() {
        studentDao.deleteById(6);
        sqlSession.commit();
    }

    //查
    @Test
    public void findAll() {
        List<Student> students= studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}