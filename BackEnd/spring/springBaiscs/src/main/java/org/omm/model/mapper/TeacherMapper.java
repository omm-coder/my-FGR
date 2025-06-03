package org.omm.model.mapper;

import org.omm.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TeacherMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(rs.getInt(1));
        teacher.setTeacher_name(rs.getString(2));
        teacher.setTeacher_gender(rs.getString(3));
        teacher.setTeacher_phone(rs.getString(4));
        teacher.setTeacher_address(rs.getString(5));
        return teacher;
    }
}
