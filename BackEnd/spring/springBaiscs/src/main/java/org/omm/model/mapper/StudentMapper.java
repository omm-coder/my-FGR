package org.omm.model.mapper;


import org.omm.model.Student;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setStudent_id(rs.getInt(1));
        student.setStudent_name(rs.getString(2));
        student.setStudent_gender(rs.getString(3));
        student.setStudent_phone(rs.getString(4));
        student.setStudent_address(rs.getString(5));
        student.setDate_entry(rs.getDate(6));

        return student;
    }
}
