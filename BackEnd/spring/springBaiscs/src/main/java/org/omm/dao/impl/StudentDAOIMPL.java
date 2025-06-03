package org.omm.dao.impl;

import org.omm.dao.StudentDAO;
import org.omm.model.Student;
import org.omm.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDAOIMPL implements StudentDAO {

    @Autowired
    private NamedParameterJdbcTemplate np_jdbc_template;

    @Override
    public void saveStudent(Student student) {
        String sql = "INSERT INTO student (student_name, student_gender, " +
                "student_phone, student_address, date_entry) values(:student_name, :student_gender, " +
                ":student_phone ,:student_address ,:date_entry)";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("student_name",student.getStudent_name());
        map.put("student_gender", student.getStudent_gender());
        map.put("student_phone", student.getStudent_phone());
        map.put("student_address", student.getStudent_address());
        map.put("date_entry",student.getDate_entry());

        np_jdbc_template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public Student findStudentById(int id) {
        String sql = "Select * from student where student_id = :student_id";
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("student_id", id);
        return np_jdbc_template.queryForObject(sql, parameters,new StudentMapper());
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "update student set student_name = :student_name," +
                "student_gender = :student_gender, student_phone = :student_phone," +
                "student_address = :student_address, date_entry = :date_entry" +
                " where student_id = :student_id";
        Map<String,Object> parameters = new HashMap<String,Object>();

        parameters.put("student_name",student.getStudent_name());
        parameters.put("student_gender", student.getStudent_gender());
        parameters.put("student_phone", student.getStudent_phone());
        parameters.put("student_address", student.getStudent_address());
        parameters.put("date_entry",student.getDate_entry());
        parameters.put("student_id", student.getStudent_id());




        np_jdbc_template.update(sql,parameters);
    }

    @Override
    public ArrayList<Student> getAlStudents() {
        String sql = "Select * from student";

        return (ArrayList<Student>) np_jdbc_template.query(sql, new StudentMapper());
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "Delete from student where student_id = :student_id";
        Map<String, Integer> parameter = new HashMap<String, Integer>();
        parameter.put("student_id", id);
        np_jdbc_template.update(sql, parameter);
    }

    @Override
    public List<Student> getStudentsByAddress(String address) {
        String sql = "Select * from student where student_address = :student_address";
        Map<String,String> param = new HashMap<>();
        param.put("student_address",address);
        return np_jdbc_template.query(sql, param, new StudentMapper());
    }

    @Override
    public List<Student> getStudentsByPage(int pageId, int total) {
        String sql = "select * from student limit "+ (pageId-1)+", "+ total;
        return np_jdbc_template.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
