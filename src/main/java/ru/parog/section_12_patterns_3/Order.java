package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private BigDecimal price;
    private String email;
    private String address;
    private PaymentMethodEnum paymentMethod;
    private List<Product> products;
    private BigDecimal balance;
    private boolean isFraud;

    public Order(BigDecimal price, String email, String address,
                 PaymentMethodEnum paymentMethod, List<Product> products,
                 BigDecimal balance, boolean isFraud) {
        this.price = price;
        this.email = email;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.products = products;
        this.balance = balance;
        this.isFraud = isFraud;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isFraud() {
        return isFraud;
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", productsCount=" + products.size() +
                '}';
    }
}
