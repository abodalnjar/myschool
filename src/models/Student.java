package models;

public class Student extends Person{
    String pPn;

    public Student(String name, int age, String pPn) {
        super(name, age);
        this.pPn = pPn;
    }

    public Student() {
    }

    @Override
    public String dadta() {
        return this.getName()+"  "+ this.getAge()+"  "+this.getpPn();
    }

    public String getpPn() {
        return pPn;
    }

    public void setpPn(String pPn) {
        this.pPn = pPn;
    }
}
