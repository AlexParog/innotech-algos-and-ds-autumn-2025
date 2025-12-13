package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;

public class PhysicalOrderProcessor extends AbstractOrderProcessor {

    private static final BigDecimal FIXED_SHIPPING_PRICE = new BigDecimal("99.99");

    @Override
    void validate(Order order) {
        if (order.getAddress() == null || order.getAddress().isBlank()) {
            throw new IllegalArgumentException("Адрес доставки должен быть обязательно заполнен!");
        }
        System.out.println("Адрес проверен: " + order.getAddress());
    }

    @Override
    void calculatePrice(Order order) {
        BigDecimal totalPrice = order.getPrice().add(FIXED_SHIPPING_PRICE);
        order.setPrice(totalPrice);
        System.out.println("Цена + доставка рассчитаны: " + totalPrice);
    }

    @Override
    void pay(Order order) {
        System.out.println("Оплата при получении на сумму: " + order.getPrice());
    }
}
