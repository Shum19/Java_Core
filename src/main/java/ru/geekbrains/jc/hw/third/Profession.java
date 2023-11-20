package ru.geekbrains.jc.hw.third;

import java.util.Comparator;
import java.util.Objects;

public  abstract class  Profession {
    protected String title;
    protected double salary;
    protected Profession(String title, double salary){
        this.title = title;
        this.salary = salary;
    }
    public void setProfession(String title, double salary){
        this.title = title;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    protected abstract double averageSalary();
    public String info(){
        return "Title - " + this.title + ", Salary - " + this.salary;
    }


}
