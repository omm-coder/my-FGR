package org.omm.service.impl;

import org.omm.dao.impl.TeacherDAOIMPL;
import org.omm.model.Teacher;
import org.omm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherDAOIMPL teacherDAOIMPL;

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDAOIMPL.saveTeacher(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return teacherDAOIMPL.findTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDAOIMPL.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> getALLTeacher() {
        return teacherDAOIMPL.getALLTeachers();
    }

    @Override
    public void deleteTeacher(int id) {
        teacherDAOIMPL.deleteTeacher(id);
    }
}
