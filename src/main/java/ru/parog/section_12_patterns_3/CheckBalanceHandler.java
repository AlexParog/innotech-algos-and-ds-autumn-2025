package ru.parog.section_12_patterns_3;

public class CheckBalanceHandler extends AbstractOrderHandler {

    public CheckBalanceHandler(AbstractOrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean check(Order order) {
        return order.getBalance().compareTo(order.getPrice()) >= 0;
    }
}
