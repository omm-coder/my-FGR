package org.omm.dao;


import org.omm.model.Teacher;

import java.util.List;

public interface TeacherDAO {

    void saveTeacher(Teacher teacher);
    Teacher findTeacherById(int id);
    void updateTeacher(Teacher teacher);
    List<Teacher> getALLTeachers();
    void deleteTeacher(int id);
}
