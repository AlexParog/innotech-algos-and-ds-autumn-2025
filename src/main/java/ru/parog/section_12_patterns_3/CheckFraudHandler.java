package ru.parog.section_12_patterns_3;

public class CheckFraudHandler extends AbstractOrderHandler {

    public CheckFraudHandler(AbstractOrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean check(Order order) {
        return !order.isFraud();
    }
}
