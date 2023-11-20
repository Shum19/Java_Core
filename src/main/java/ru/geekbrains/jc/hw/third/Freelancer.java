package ru.geekbrains.jc.hw.third;

public class Freelancer extends Profession{
    private double hourRate;
    private Freelancer(String title, double salary){
        super(title, salary);
    }
    public static Freelancer create(String title, double salary){
        if (title == "" || title == " "){ new RuntimeException("Пустое поле наименования профессии");}
        if (salary < 0){new RuntimeException("Заработная плата меньше 0");}
        return new Freelancer(title, salary);
    }
    @Override
    protected double averageSalary() {
        return 20.8 * 8 * hourRate;
    }
    public void setHourRate(double hourRate ){
        this.hourRate = hourRate;
    }
    public double getHourRate(){
        return hourRate;
    }

}
