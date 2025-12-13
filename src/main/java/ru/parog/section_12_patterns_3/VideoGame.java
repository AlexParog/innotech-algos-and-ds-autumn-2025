package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;

public class VideoGame implements Product {

    private String title;
    private BigDecimal price;

    public VideoGame(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVideoGame(this);
    }
}
