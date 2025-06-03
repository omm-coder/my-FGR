package org.omm.service;

import org.omm.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface TeacherService {

    void saveTeacher(Teacher teacher);
    Teacher findTeacherById(int id);
    void updateTeacher(Teacher teacher);
    List<Teacher> getALLTeacher();
    void deleteTeacher(int id);
}
