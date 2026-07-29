package org.bernardomecabo.OOPExamples.Encapsulation.BankExample;

import org.bernardomecabo.OOPExamples.Encapsulation.BankExample.entities.BankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        Scanner input = new Scanner(System.in);

        double depositAmount = 0.0;
        System.out.print("Enter your account number: ");
        int accountNumber = input.nextInt();
        System.out.print("Enter your account holder name: ");
        String accountName = input.next();
        System.out.print("Is there an initial deposit into your account holder? (Y/N) ");
        String answer = input.next();
        boolean initialDeposit = answer.equalsIgnoreCase("Y");

        if(initialDeposit){
            System.out.print("Enter a deposit amount: ");
            depositAmount = input.nextDouble();
        }
        BankAccount account = new BankAccount(accountNumber,accountName ,depositAmount ,initialDeposit);
        System.out.println(account.toString() + "\n");

        System.out.println("===== MENU =====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("================");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter deposit amount: ");
                depositAmount = input.nextDouble();
                account.deposit(depositAmount);
                System.out.println(account.toString() + "\n");
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                depositAmount = input.nextDouble();
                account.withdraw(depositAmount);

                System.out.println(account.toString() + "\n");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
