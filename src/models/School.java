package models;

import java.util.ArrayList;

public class School {
    String name;
    String address;
    String phonN;

    ArrayList<Student> students;
    ArrayList<Teacher> teachers;
    ArrayList<Grade> grades;

    public School() {
        this.initO();
    }
    public School(String name) {
        this.name = name;
        this.initO();
    }

    private void  initO(){
        this.students =new ArrayList<Student>();
        this.teachers =new ArrayList<Teacher>();
        this.grades =new ArrayList<Grade>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhonN() {
        return phonN;
    }
    public void setPhonN(String phonN) {
        this.phonN = phonN;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<Grade> getGrades() {
        return grades;
    }
}
