package org.omm.dao.impl;

import org.omm.dao.TeacherDAO;
import org.omm.model.Teacher;
import org.omm.model.mapper.Teacher_RS_Extractor;
import org.omm.model.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOIMPL implements TeacherDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveTeacher(Teacher teacher) {

        Object[] args = {teacher.getTeacher_name(), teacher.getTeacher_gender(),
                teacher.getTeacher_phone(),teacher.getTeacher_address()};
        String sql = "insert into teachers " +
                "(teacher_name, teacher_gender, teacher_phone, teacher_address)" +
                "values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, args);
    }

    @Override
    public Teacher findTeacherById(int id) {
        String sql = "Select * from teachers where teacher_id = ?";
        return  jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Teacher.class), id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "Update teachers set teacher_name = ?, teacher_gender = ?," +
                "teacher_phone = ?, teacher_address = ? where teacher_id = ?";
        Object[] args = {teacher.getTeacher_name(), teacher.getTeacher_gender(),
                teacher.getTeacher_phone(),teacher.getTeacher_address(),
                teacher.getTeacher_id()};
        jdbcTemplate.update(sql, args);

    }

    @Override
    public List<Teacher> getALLTeachers() {
        String sql = "SELECT * FROM teachers";
        return jdbcTemplate.query(sql, new Teacher_RS_Extractor());
    }

    @Override
    public void deleteTeacher(int id) {
        String sql = "delete from teachers where teacher_id = ?";
        jdbcTemplate.update(sql);
    }
}
