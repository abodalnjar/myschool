package services;

import models.Grade;
import models.School;
import models.Student;
import models.Teacher;

import java.util.Locale;

public class Schoolservices {

    School school;

    public Schoolservices(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void addstude(Student student){
        this.school.getStudents().add(student);
    }
    public void addTech (Teacher teacher){
        this.school.getTeachers().add(teacher);

    }
    public void addGrad(Grade grade){
        this.school.getGrades().add(grade);
    }
    public void revStu(Student student){
        this.school.getStudents().remove(student);
    }
    public void revtrch(Teacher teacher){
        this.school.getTeachers().remove(teacher);
    }
    public void revStu(Grade grade){
        this.school.getGrades().remove(grade);
    }
    public Student getStuNameS(String name){
        Student a= null;
        for (Student student: this.school.getStudents()){
            if (student.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                a=student;
               break;
            }
        }
        return a;
    }
    public Teacher getTechNamS(String name){
        for (Teacher teacher:this.school.getTeachers()){
            if (teacher.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                return teacher;
            }
        }
        return null;
    }
    public Grade getGreNamS(String code){
        for (Grade grade:this.school.getGrades()){
            if (grade.getCode().equals(code)){
                return grade;
            }
        }
        return null;
    }
}
