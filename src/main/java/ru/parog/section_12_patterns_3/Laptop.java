package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;

public class Laptop implements Product {
    private String model;
    private BigDecimal price;

    public Laptop(String model, BigDecimal price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLaptop(this);
    }
}
