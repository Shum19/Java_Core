package ru.geekbrains.jc.hw.third;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ProfessionList implements Iterable <Profession> {
    private List<Profession> profession;
    private int size;
    public ProfessionList(){
        profession = new ArrayList<>();
        size = profession.size();

    }
    public void setProfession(Profession profession){
        this.profession.add(profession);
    }
    public Profession getProfession(int index){
        return profession.get(index);
    }

    @Override
    public void forEach(Consumer<? super Profession> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Profession> spliterator() {
        return Iterable.super.spliterator();
    }
    @Override
    public Iterator<Profession> iterator() {
        return new Iterator<Profession>() {
            @Override
            public boolean hasNext() {
                return size < profession.size();
            }
            @Override
            public Profession next() {
                return profession.get(size++);
            }
        };
    }
}
