package com.bpzj.jdbcTemplate.dao.Impl;

import com.bpzj.jdbcTemplate.dao.StudentDao;
import com.bpzj.jdbcTemplate.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("studentDaoImpl")
public class StudentDaoImpl extends BaseDao implements StudentDao {

    //增加一条数据，实现接口
    @Override
    public void add(Student student) {
        String sql = "INSERT INTO sign values(NULL,NOW(),NOW(),?,?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{
                student.getName(),student.getQq(), student.getType(),
                student.getEntryTime(),student.getSchool(),
                student.getStudentId(),student.getLink(),student.getOath(),
                student.getBrother(),student.getKnowFrom(),
        };
        this.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM sign WHERE id=?";
        this.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void updateById(Student student) {
        String sql = "UPDATE sign SET update_at=NOW(), name=?,qq=?,type=?,oath=? WHERE id=?";
        Object[] params = new Object[]{
                student.getName(), student.getQq(),
                student.getType(), student.getOath(),
                student.getId(),
        };
        this.getJdbcTemplate().update(sql, params);

    }

    @Override
    public Student getById(int id) {
        String sql = "SELECT * FROM sign WHERE id=?";
        Student student =(Student) this.getJdbcTemplate().queryForObject(sql, new StudentRow(), id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM  sign";

        //使用 RowMapper 回调函数构造的 StudentRow()
        List studentList = this.getJdbcTemplate().query(sql, new StudentRow());
        return studentList;
    }

    @Override
    public List<Student> findAll(int start, int count) {
        String sql = "SELECT * FROM  sign LIMIT ?,?";

        //使用 RowMapper 回调函数构造的 StudentRow()
        List studentList = this.getJdbcTemplate().query(sql, new StudentRow(), start, count);
        return studentList;
    }
}
