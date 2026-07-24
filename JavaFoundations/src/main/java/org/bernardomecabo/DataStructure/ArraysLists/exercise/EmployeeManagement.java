package org.bernardomecabo.DataStructure.ArraysLists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    static void main() {
        Scanner input = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int numberOfEmployees = input.nextInt();

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = input.nextInt();
            System.out.print("Name: ");
            input.nextLine();
            String name = input.next();
            System.out.print("Salary: ");
            double salary = input.nextDouble();

            Employee employee = new Employee(id, name, salary);
            employees.add(employee);
            System.out.println();
        }

        System.out.println();
        System.out.print("Enter the employee ID that will have a salary increase: ");
        int id = input.nextInt();
        Employee employee = employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee  == null) {
            System.out.println("No employee with that ID was found.");
        }else {
            System.out.print("Enter the percentage of increase salary: ");
            double percentage = input.nextDouble();
            employee.increaseSalary(percentage);
        }

        System.out.println();
        employees.forEach(emp -> System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getSalary()));
    }
}
