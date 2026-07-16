package org.bernardomecabo.OOPExamples.ProductsExampleBasic;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalValueInStock() {
        return price * quantity;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void subStock(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Product Data: \n" +
                "Name: " + this.getName() + "\n" +
                "Price: " + this.getPrice() + "\n" +
                "Quantity: " + this.getQuantity() + "\n" +
                "Total Price: " + this.totalValueInStock();
    }
}
