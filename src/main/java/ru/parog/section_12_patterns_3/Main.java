package ru.parog.section_12_patterns_3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ПРИЛОЖЕНИЕ ОБРАБОТКИ ЗАКАЗОВ ===\n");

        // Создаём товары
        List<Product> products = new ArrayList<>();
        products.add(new Book("Java Design Patterns", new BigDecimal("1500")));
        products.add(new VideoGame("Cyberpunk 2077", new BigDecimal("2000")));
        products.add(new Laptop("MacBook Pro", new BigDecimal("150000")));

        // Подсчитываем общую стоимость через PriceVisitor
        PriceVisitor priceVisitor = new PriceVisitor();
        for (Product product : products) {
            product.accept(priceVisitor);
        }
        BigDecimal totalPrice = priceVisitor.getTotalPrice();

        // Формируем отчёт через ReportVisitor
        System.out.println("--- Отчёт по товарам ---");
        ReportVisitor reportVisitor = new ReportVisitor();
        for (Product product : products) {
            product.accept(reportVisitor);
        }
        System.out.println(reportVisitor.getReport());
        System.out.println("Общая стоимость товаров: " + totalPrice + "\n");

        // ===== СЦЕНАРИЙ 1: Успешный физический заказ =====
        System.out.println("=== СЦЕНАРИЙ 1: Физический заказ (успешный) ===");
        Order physicalOrder = new Order(
                totalPrice,
                "user@example.com",
                "ул. Ленина, д. 10",
                PaymentMethodEnum.UPON_RECEIPT,
                products,
                new BigDecimal("200000"), // достаточно средств
                false // не мошенничество
        );

        // Создаём цепочку проверок
        AbstractOrderHandler chain = new CheckStockHandler(
                new CheckBalanceHandler(
                        new CheckFraudHandler(null)
                )
        );

        // Запускаем проверки
        chain.handle(physicalOrder);

        // Обрабатываем заказ
        System.out.println("\n--- Обработка заказа ---");
        AbstractOrderProcessor processor = new PhysicalOrderProcessor();
        processor.processOrder(physicalOrder);

        // ===== СЦЕНАРИЙ 2: Неуспешный цифровой заказ (недостаточно средств) =====
        System.out.println("\n\n=== СЦЕНАРИЙ 2: Цифровой заказ (недостаточно средств) ===");
        Order digitalOrder = new Order(
                totalPrice,
                "buyer@mail.com",
                null,
                PaymentMethodEnum.ONLINE,
                products,
                new BigDecimal("100"), // недостаточно средств
                false
        );

        chain.handle(digitalOrder);

        // ===== СЦЕНАРИЙ 3: Успешный цифровой заказ =====
        System.out.println("\n\n=== СЦЕНАРИЙ 3: Цифровой заказ (успешный) ===");
        Order digitalOrder2 = new Order(
                totalPrice,
                "success@mail.com",
                null,
                PaymentMethodEnum.ONLINE,
                products,
                new BigDecimal("200000"),
                false
        );

        chain.handle(digitalOrder2);

        System.out.println("\n--- Обработка заказа ---");
        AbstractOrderProcessor digitalProcessor = new DigitalOrderProcessor();
        digitalProcessor.processOrder(digitalOrder2);

        // ===== СЦЕНАРИЙ 4: Мошеннический заказ =====
        System.out.println("\n\n=== СЦЕНАРИЙ 4: Мошеннический заказ ===");
        Order fraudOrder = new Order(
                totalPrice,
                "fraud@mail.com",
                "ул. Подозрительная, д. 1",
                PaymentMethodEnum.ONLINE,
                products,
                new BigDecimal("500000"),
                true // мошенничество!
        );

        chain.handle(fraudOrder);

        System.out.println("\n=== ПРИЛОЖЕНИЕ ЗАВЕРШЕНО ===");
    }
}
