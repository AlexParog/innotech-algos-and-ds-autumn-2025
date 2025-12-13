package ru.parog.section_12_patterns_3;

public interface Visitor {
    void visitBook(Book book);

    void visitVideoGame(VideoGame videoGame);

    void visitLaptop(Laptop laptop);
}
