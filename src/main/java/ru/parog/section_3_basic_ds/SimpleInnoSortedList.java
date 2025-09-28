package ru.parog.section_3_basic_ds;

import java.util.Comparator;

public class SimpleInnoSortedList<E> extends AbstractInnoSortedList<E> {
    public SimpleInnoSortedList() {
    }

    public SimpleInnoSortedList(Comparator<? super E> comparator) {
        super(comparator);
    }
}
