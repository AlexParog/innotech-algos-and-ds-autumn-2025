package ru.parog.section_12_patterns_3;

public abstract class AbstractOrderProcessor {

    public final void processOrder(Order order) {
        validate(order);
        calculatePrice(order);
        pay(order);
        notification(order);
    }

    abstract void validate(Order order);

    abstract void calculatePrice(Order order);

    abstract void pay(Order order);

    void notification(Order order) {
        System.out.println("Уведомление отправлено.");
    }

}
