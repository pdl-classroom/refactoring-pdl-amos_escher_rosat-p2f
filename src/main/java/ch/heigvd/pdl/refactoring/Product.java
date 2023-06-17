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

enum Size {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    NO_SIZE("Invalid Size");

    private String name;

    Size(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Product {

    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
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

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}