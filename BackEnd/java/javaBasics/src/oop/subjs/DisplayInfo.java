package oop.subjs;

import oop.Student;
import oop.Subject;


import java.util.ArrayList;

public class DisplayInfo {

    public static void main(String[] args) {

       Subject subject1 = new Subject("Python", 8,
               24,10,46);
        Subject subject2 = new Subject("Math", 9,
                28,10,50);
        Subject subject3 = new Subject();
        subject3.setSubjECTName("Html");
        subject3.setCourse_work1(10);
        subject3.setTerm_marks(30);
        subject3.setCourse_work2(10);
        subject3.setFinal_marks(50);


        ArrayList<Subject> allSub = new ArrayList<>();
        allSub.add(subject1);
        allSub.add(subject2);
        allSub.add(subject3);

        Student student = new Student();
        student.setIdNo(1);
        student.setName("Omm");
        student.setSubjects(allSub);

        student.details();
    }
}
