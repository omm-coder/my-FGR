package oop;

import java.util.ArrayList;

public class Student {

    int idNo;
    String name;
    ArrayList<Subject> subjects;

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {

        this.subjects = subjects;
    }

    private double getStudentTotalMarks() {
        double marks = 0.0;
        ArrayList<Subject> allSubs;
        allSubs = getSubjects();
        assert allSubs != null;
        for (Subject subject: allSubs)
            marks += subject.subjectTotalMarks();
        return marks;
    }

    public void details() {
        System.out.println("-----------Student Details-------------");
        System.out.println("Student ID: "+ getIdNo());
        System.out.println("Student Name: "+ getName());
        System.out.println("Student marks: "+ getStudentTotalMarks());
        System.out.println("----------Student Subjects-------------");
        System.out.println("Student takes "+ subjects.size()+ " subjects");
        for (Subject subject : subjects) {
            System.out.println("Subject name: "+ subject.getSubjECTName());
            System.out.println("Course_Work1_Marks: "+ subject.getCourse_work1());
            System.out.println("Term_Marks: "+ subject.getTerm_marks());
            System.out.println("Course_Work2_marks: "+ subject.getCourse_work2());
            System.out.println("Final_Marks: "+ subject.getFinal_marks());
            System.out.println("Total_marks: "+ subject.subjectTotalMarks());
            System.out.println(".............................................");
            System.out.println();
        }

    }
}
