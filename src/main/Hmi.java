package main;

import models.*;
import services.Schoolservices;
import tools.Action;

import java.util.Scanner;

public class Hmi {
    private static Schoolservices schoolservices;
    private static Grade grade;
    public static void start() {
        School school = Hmi.craet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcom to " + school.getName() + "  " + "in" + school.getAddress());
        String action;
        do {
            System.out.println("what do you want to do?");
            action = scanner.next();
            switch (action) {
                case "addstu":
                    Hmi.addstud();
                    break;
                case "addTch":
                    Hmi.addsTech();
                    break;
                case "prentaddstu":
                    Hmi.prentaddstu();
                    break;
                case "prentaddTech":
                    Hmi.prentaddTich();
                    break;
                case "findStuBY":
                    Hmi.printfindParsBY(Action.STOUDIN);
                    break;
                case "findTeaBY":
                    Hmi.printfindParsBY(Action.TEACHAR);
                    break;
                case "remvoStudent":
                    Hmi.remvoPason(Action.STOUDIN);
                    break;
                case "remvoTeachr":
                    Hmi.remvoPason(Action.TEACHAR);
                    break;
                case "addgradl":
                    Hmi.addaGrde();
                    break;
                case "prentaddgradel":
                    Hmi.prentaddgradel();
                    break;
            }
        } while (!action.equals("exit"));
    }
    private static School craet() {
        School school = new School();
        school.setName("Barmja");
        school.setAddress("Yemen");
        school.setPhonN("123465");
        Hmi.schoolservices = new Schoolservices(school);
        return school;
    }
    private static void addstud() {
        Student student = new Student();
        Hmi.setdataparson(student);
        Hmi.schoolservices.addstude(student);
    }
    private static void addsTech() {
    Teacher teacher = new Teacher();
    Hmi.setdataparson(teacher);
    Hmi.schoolservices.addTech(teacher);
    }
    private static void addaGrde() {
        Grade grade = new Grade();
        Hmi.setGrade(grade);
        Hmi.schoolservices.addGrad(grade);
    }
    public static void setGrade(Grade grade){
        Scanner reder = new Scanner(System.in);
        System.out.println("pliz entr code");
        grade.setCode(reder.next());
        System.out.println("plis enter name");
        grade.setName(reder.next());
       // schoolservices.addGrad(grade);
    }
    public static void prentaddgradel() {
        for (Grade grade : Hmi.schoolservices.getSchool().getGrades()) {
            System.out.println(grade.dadta());
        }
    }
    public static void prentaddstu() {
        for (Student student : Hmi.schoolservices.getSchool().getStudents()) {
            System.out.println(student.dadta());
        }
    }
    public static void prentaddTich() {
        for (Teacher teacher : Hmi.schoolservices.getSchool().getTeachers()) {
            System.out.println(teacher.dadta());
        }
    }
    private static void setdataparson(Person p){
        Scanner reder = new Scanner(System.in);
        System.out.println("pliz entr namber");
        p.setName(reder.next());
        System.out.println("plis enter Age");
        p.setAge(reder.nextInt());
        if (p instanceof Teacher){
            System.out.println("pliz enter slare");
            ((Teacher) p).setSalary(reder.nextFloat());
        }else if (p instanceof Student){
            System.out.println("pliz enter phon");
            ((Student) p).setpPn(reder.next());
        }
    }
    private static void printfindParsBY(Action action){
        Person p =Hmi.findParsBY(action);
        Hmi.printShow(p);

    }
    private static void printShow(Person person) {
        if (person == null) {
            System.out.println("not foind");
        } else {
            System.out.println(person.dadta());
        }
    }

    private static Person findParsBY(Action action){
        Scanner reade =new Scanner(System.in);
        System.out.println("in name the fanal");
        String name= reade.next();
        Person p;
        if (action==Action.STOUDIN){
            p=Hmi.schoolservices.getStuNameS(name);
        }else {
            p = Hmi.schoolservices.getTechNamS(name);
        }
        return p;
    }
    private static void remvoPason(Action action){
        Person p =Hmi.findParsBY(action);
        if (p instanceof Student){
            Hmi.schoolservices.revStu((Student) p);
        }else {
            Hmi.schoolservices.revtrch((Teacher) p);
        }
    }

}