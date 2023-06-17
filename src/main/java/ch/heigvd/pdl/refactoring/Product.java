package ch.heigvd.pdl.refactoring;

enum Color {
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow"),
    NOCOLOR("no color");

    private String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Product {

    public static final int SIZE_NOT_APPLICABLE = -1;

    private String code;
    private Color color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, Color color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}