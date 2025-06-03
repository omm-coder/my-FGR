package org.omm.service.impl;

import org.omm.dao.impl.StudentDAOIMPL;
import org.omm.model.Student;
import org.omm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentDAOIMPL studentDAOIMPL;

    @Override
    public void saveStudent(Student student) {
        studentDAOIMPL.saveStudent(student);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDAOIMPL.findStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAOIMPL.updateStudent(student);
    }

    @Override
    public ArrayList<Student> getAlStudents() {
        return studentDAOIMPL.getAlStudents();
    }

    @Override
    public void deleteStudent(int id) {
        studentDAOIMPL.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByAddress(String address) {
        return studentDAOIMPL.getStudentsByAddress(address);
    }

    @Override
    public List<Student> getStudentsByPage(int pageId, int total) {
        return studentDAOIMPL.getStudentsByPage(pageId,total);
    }
}
