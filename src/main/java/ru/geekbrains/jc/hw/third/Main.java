package ru.geekbrains.jc.hw.third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String [] arg){
        String [] titles = {"Worker_1", "Worker_2", "Worker_3", "Freelancer_1", "Freelancer_2", "Freelancer_3"};
        double [] salaries = {1200, 1000, 1500, 50, 60, 45.45};
        List <Profession> professions = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            professions.add(Worker.create(titles[i], salaries[i]));
        }
        for (int i = 3; i < 6; i++) {
            professions.add(Freelancer.create(titles[i], salaries[i]));
        }
        ProfessionList professionsList = new ProfessionList();
        for (Profession pr: professions) {
            professionsList.setProfession(pr);

        }
        System.out.println("Не сортированный список");
        for (Profession pr:professionsList) {
            System.out.println(pr.info());
        }


        Comparator prcomp = new ProfessionComparator();
        TreeSet<Profession> professionTreeSet = new TreeSet<>(prcomp);
        for (int i = 0; i < 3; i++) {
            professionTreeSet.add(Worker.create(titles[i], salaries[i]));
        }
        for (int i = 3; i < 6; i++) {
            professionTreeSet.add(Freelancer.create(titles[i], salaries[i]));
        }
        System.out.println("Сортированный список по зарплате");
        for (Profession pr : professionTreeSet) {
            System.out.println(pr.info());

        }
    }
}
