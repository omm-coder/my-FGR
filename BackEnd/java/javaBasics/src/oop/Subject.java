package oop;



public class Subject {

    private String subjectName;
    private double course_work1;
    private double term_marks;
    private double course_work2;
    private double final_marks;

    public Subject(){}

    public Subject(String subjectName, double course_work1, double term_marks,
                    double course_work2, double final_marks) {
        this.subjectName = subjectName;
        if (course_work1 >= 0 && course_work1 <= 10)
            this.course_work1 = course_work1;
        if (term_marks >= 0 && term_marks <= 30)
            this.term_marks = term_marks;
        if (course_work2 >= 0 && course_work2 <= 10)
            this.course_work2 = course_work2;
        if (final_marks >= 0 && final_marks <= 50)
            this.final_marks = final_marks;
    }

    public String getSubjECTName() {
        return subjectName;
    }

    public void setSubjECTName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getCourse_work1() {
        return course_work1;
    }

    public void setCourse_work1(double course_work1) {
        if (course_work1 >= 0 && course_work1 <= 10)
            this.course_work1 = course_work1;
    }

    public double getTerm_marks() {
        return term_marks;
    }

    public void setTerm_marks(double term_marks) {
        if (term_marks >= 0 && term_marks <= 30)
            this.term_marks = term_marks;
    }

    public double getCourse_work2() {
        return course_work2;
    }

    public void setCourse_work2(double course_work2) {
        if (course_work2 >= 0 && course_work2 <= 10)
            this.course_work2 = course_work2;
    }

    public double getFinal_marks() {
        return final_marks;
    }

    public void setFinal_marks(double final_marks) {
        if (final_marks >= 0 && final_marks <= 50)
            this.final_marks = final_marks;
    }

    public double subjectTotalMarks() {
        return getCourse_work1() + getTerm_marks() +
                getCourse_work2() + getFinal_marks();
    }
}
