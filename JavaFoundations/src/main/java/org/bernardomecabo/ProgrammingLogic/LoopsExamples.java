package org.bernardomecabo.ProgrammingLogic;

import java.util.Scanner;

public class LoopsExamples {
    public static void whileLoop(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write a number: ");
        System.out.println("To quit write 0");
        int num = input.nextInt();
        while (num != 0){
            num = input.nextInt();
        }

        input.close();
    }

    public static void forLoop(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write the amount of numbers to be inserted: ");
        double sum = 0;
        int iterations = input.nextInt();
        System.out.println("Write each number: ");
        for (int i = 0; i < iterations; i++){
            sum += input.nextDouble();
        }
        System.out.println("The sum is " + sum);
    }
}
