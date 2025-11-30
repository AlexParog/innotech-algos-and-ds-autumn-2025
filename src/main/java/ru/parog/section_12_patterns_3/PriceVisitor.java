package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;

public class PriceVisitor implements Visitor {

    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Override
    public void visitBook(Book book) {
        totalPrice = totalPrice.add(book.getPrice());
    }

    @Override
    public void visitVideoGame(VideoGame videoGame) {
        totalPrice = totalPrice.add(videoGame.getPrice());
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        totalPrice = totalPrice.add(laptop.getPrice());
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
