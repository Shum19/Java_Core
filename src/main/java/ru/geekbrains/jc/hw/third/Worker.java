package ru.geekbrains.jc.hw.third;

public class Worker extends Profession{
    private Worker(String title, double salary) {
        super(title, salary);
    }

    public static Worker create(String title, double salary){
        if (title == "" || title == " "){ new RuntimeException("Пустое поле наименования профессии");}
        if (salary <= 1000){new RuntimeException("Заработная плата меньше 1000$");}
        return new Worker(title, salary);
    }
    @Override
    protected double averageSalary() {
        return salary;
    }


}
