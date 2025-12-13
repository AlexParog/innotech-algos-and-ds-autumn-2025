package ru.parog.section_12_patterns_3;

public abstract class AbstractOrderHandler {

    protected AbstractOrderHandler nextHandler;

    public AbstractOrderHandler(AbstractOrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Order order) {
        if (check(order)) {
            System.out.println(this.getClass().getSimpleName() + " проверка прошла.");
            if (nextHandler != null) nextHandler.handle(order);
        } else {
            System.out.println(this.getClass().getSimpleName() + " ошибка.");
        }
    }

    protected abstract boolean check(Order order);
}
