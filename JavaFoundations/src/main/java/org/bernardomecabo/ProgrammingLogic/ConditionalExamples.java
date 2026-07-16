package org.bernardomecabo.ProgrammingLogic;

import java.util.Scanner;

public class ConditionalExamples {
    public static void phoneBill(int minutes) {
        double price = 50;
        if (minutes < 100) {
            System.out.println(price);
        }else {
            price += ((minutes - 100) * 2);
            System.out.println(price);
        }
    }

    public static void switchCaseExample(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Write your name: ");
        String name = sc.nextLine();

        switch (name) {
            case "Bernardo":
                System.out.println("Approved");
                break;
            case "Carlos":
                System.out.println("Approved");
                break;
            case "Pedro":
                System.out.println("Approved");
                break;
            default:
                System.out.println("Not Approved");
                break;
        }

    }

    public static void ternaryConditionalExample(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the deposit value: ");
        double deposit = sc.nextDouble();
        double taxedDeposit = (deposit >= 200) ? deposit : deposit - (deposit * 0.1);
        System.out.println("Your deposit value: " + deposit + "$");
        System.out.println("Your taxed deposit value: " + taxedDeposit + "$");
    }
}
