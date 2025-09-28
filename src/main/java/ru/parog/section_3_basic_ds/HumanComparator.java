package ru.parog.section_3_basic_ds;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getSocialRating(), o2.getSocialRating());
    }
}
