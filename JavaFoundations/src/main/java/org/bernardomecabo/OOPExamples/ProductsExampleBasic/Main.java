package org.bernardomecabo.OOPExamples.ProductsExampleBasic;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter product data:");
        System.out.print("Name: ");
        String name = in.next();
        System.out.print("Price: ");
        double price = in.nextDouble();
        System.out.print("Quantity: ");
        int quantity = in.nextInt();
        System.out.println();

        Product product = new Product(name, price, quantity);
        System.out.println(product.toString());
        System.out.println();

        System.out.println("Enter the number of items to be added in the stock: ");
        int items = in.nextInt();
        product.addStock(items);

        System.out.println();
        System.out.println(product.toString());
        System.out.println();

        System.out.println("Enter the number of items to be removed in the stock: ");
        items = in.nextInt();
        product.subStock(items);

        System.out.println();
        System.out.println(product.toString());
    }
}
