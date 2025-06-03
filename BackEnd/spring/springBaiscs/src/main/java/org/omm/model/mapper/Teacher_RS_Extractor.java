package org.omm.model.mapper;

import org.omm.model.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher_RS_Extractor implements ResultSetExtractor<List<Teacher>> {
    @Override
    public List<Teacher> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        ArrayList<Teacher> teachersList = new ArrayList<>();
        while (rs.next()) {

            Teacher teacher = new Teacher();
            teacher.setTeacher_id(rs.getInt(1));
            teacher.setTeacher_name(rs.getString(2));
            teacher.setTeacher_gender(rs.getString(3));
            teacher.setTeacher_phone(rs.getString(4));
            teacher.setTeacher_address(rs.getString(5));

            teachersList.add(teacher);
        }
        return teachersList;
    }
}
