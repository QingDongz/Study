package com.bpzj.jdbcTemplate.dao.CanNotUse;

import com.bpzj.jdbcTemplate.dao.StudentDao;
import com.bpzj.jdbcTemplate.domain.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


//@Repository("studentDaoImplTwo")
public class StudentDaoImplTwo extends JdbcDaoSupport implements StudentDao {

    /*
    extends JdbcDaoSupport 需要在xml文件中指定 JdbcTemplate，或者在类内部重新
    定义，但是这种方式不支持 注解配置bean，（因为 继承JdbcDaoSupport无法对
    JdbcTemplate成员变量应用@Autowired注解），随着最近，注解配置成为主流，推荐的
    做法是自己定义一个BaseDao，在BaseDao中定义JdbcTemplate成员变量，并在
    其setter方法上标注@Autowired注解。  在实际项目中，还会在BaseDao中定义一些
    通用的功能，如声明JdbcTemplate、分页查询等。
    */

    @Override
    public void add(Student student) {
        String sql = "INSERT INTO student values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{
                student.getCreateAt(), student.getUpdateAt(), student.getName(),
                student.getQq(), student.getType(),student.getEntryTime(),
                student.getSchool(),student.getStudentId(),student.getLink(),
                student.getOath(),student.getBrother(),student.getKnowFrom(),
        };

        this.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        this.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void updateById(Student student) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public List<Student> findAll(int start, int count) {
        return null;
    }
}
