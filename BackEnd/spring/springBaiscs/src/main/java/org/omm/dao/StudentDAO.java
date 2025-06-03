package org.omm.dao;

import org.omm.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {


    void saveStudent(Student student);
    Student findStudentById(int id);
    void updateStudent(Student student);
    ArrayList<Student> getAlStudents();
    void deleteStudent(int id);
    List<Student> getStudentsByAddress(String address);

//    This method for Pagination
    List<Student> getStudentsByPage(int pageId, int total);
}
