package org.bernardomecabo.JavaMethods.Enum.exercise;

import org.bernardomecabo.JavaMethods.Enum.exercise.entities.Department;
import org.bernardomecabo.JavaMethods.Enum.exercise.entities.HourContract;
import org.bernardomecabo.JavaMethods.Enum.exercise.entities.Worker;
import org.bernardomecabo.JavaMethods.Enum.exercise.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = input.next();

        System.out.println("\nEnter worker data:");
        System.out.print("Name: ");
        String workersName = input.next();
        System.out.print("Level: ");
        String workerLevel = input.next();
        System.out.print("Base salary: ");
        double baseSalary = input.nextDouble();
        System.out.print("How many contracts to this worker: ");
        int contracts = input.nextInt();
        System.out.println();

        Worker worker = new Worker(workersName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        for (int i = 1; i <= contracts; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(input.next());
            System.out.print("Value per hour: ");
            double value = input.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = input.nextInt();
            System.out.println();

            worker.addContract(new HourContract(contractDate, value, hours));
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYYY): ");
        String monthAndYear = input.next();

        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println();
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " +  monthAndYear + ": " + worker.income(month, year));


    }
}
