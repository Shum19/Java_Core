package ru.geekbrains.jc.hw.third;

import java.util.Comparator;

public class ProfessionComparator implements Comparator<Profession> {
    @Override
    public int compare(Profession pr1, Profession pr2) {
        if (pr1.getSalary() > pr2.getSalary()){
            return 1;
        } else if (pr1.getSalary() < pr2.getSalary()) {
            return -1;
        }else return 0;
    }

}
