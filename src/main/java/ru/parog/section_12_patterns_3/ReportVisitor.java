package ru.parog.section_12_patterns_3;

public class ReportVisitor implements Visitor {

    private StringBuilder report = new StringBuilder();

    @Override
    public void visitBook(Book book) {
        report.append("Книга: ").append(book.getTitle())
                .append(", цена: ").append(book.getPrice()).append("\n");
    }

    @Override
    public void visitVideoGame(VideoGame videoGame) {
        report.append("Видеоигра: ").append(videoGame.getTitle())
                .append(", цена: ").append(videoGame.getPrice()).append("\n");
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        report.append("Ноутбук: ").append(laptop.getModel())
                .append(", цена: ").append(laptop.getPrice()).append("\n");
    }

    public String getReport() {
        return report.toString();
    }
}
