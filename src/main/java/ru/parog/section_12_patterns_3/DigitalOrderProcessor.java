package ru.parog.section_12_patterns_3;

public class DigitalOrderProcessor extends AbstractOrderProcessor {

    @Override
    void validate(Order order) {
        if (order.getEmail() == null || order.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email должен быть обязательно заполнен!");
        }
        System.out.println("Электронный адрес проверен.");
    }

    @Override
    void calculatePrice(Order order) {
        System.out.println("Доставка отсутствует. Цена не меняется: " + order.getPrice());
    }

    @Override
    void pay(Order order) {
        System.out.println("Оплата онлайн на сумму: " + order.getPrice());
    }
}
