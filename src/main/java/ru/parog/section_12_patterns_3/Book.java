package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;

public class Book implements Product {

    private String title;
    private BigDecimal price;

    public Book(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }
}
