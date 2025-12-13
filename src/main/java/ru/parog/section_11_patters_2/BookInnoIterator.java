package ru.parog.section_11_patters_2;

import java.util.NoSuchElementException;

public class BookInnoIterator implements InnoIterator<Book> {

    private final Book[] books;
    private int index;

    public BookInnoIterator(Book[] books) {
        this.books = books;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < books.length;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше нет элементов в коллекции");
        }

        Book book = books[index];
        index++;
        return book;
    }
}
