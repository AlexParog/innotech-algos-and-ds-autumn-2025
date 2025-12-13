package ru.parog.section_12_patterns_3;

public class CheckStockHandler extends AbstractOrderHandler {

    public CheckStockHandler(AbstractOrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean check(Order order) {
        return order.getProducts() != null && order.getProducts().isEmpty();
    }
}
