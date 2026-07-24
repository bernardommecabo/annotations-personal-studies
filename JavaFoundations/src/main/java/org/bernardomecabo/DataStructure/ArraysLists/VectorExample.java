package org.bernardomecabo.DataStructure.ArraysLists;

import java.util.Scanner;

public class VectorExample {
    static void main() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = input.nextInt();
        double sum = 0.0;
        double[] arr = new double[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter height in meters: ");
            arr[i] = input.nextDouble();
            sum += arr[i];
        }

        System.out.println("\nThe sum of the elements in the array is: " + sum);
        System.out.println("The average of the elements in the array is: " + sum/arr.length);
    }
}
