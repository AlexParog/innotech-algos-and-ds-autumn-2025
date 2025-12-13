package ru.parog.section_11_patters_2;

import java.util.Arrays;

public class BookCollection {

    private static final int DEFAULT_SIZE = 10;

    private Book[] books;
    private int size;

    public BookCollection() {
        this.books = new Book[DEFAULT_SIZE];
        this.size = 0;
    }

    public void add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Книга не может быть null");
        }

        if (size == books.length) {
            expandCapacity();
        }

        books[size] = book;
        size++;
    }

    public InnoIterator<Book> iterator() {
        Book[] actualBooks = Arrays.copyOf(books, size);
        return new BookInnoIterator(actualBooks);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expandCapacity() {
        int newCapacity = books.length * 2;
        books = Arrays.copyOf(books, newCapacity);
    }
}
