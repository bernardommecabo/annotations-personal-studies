package Collections;

import java.util.*;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Integer> inputToArray(String input){
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().toList();
    }
    private static Integer add(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }
    private static Integer subtract(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).reduce(0,(a,b)-> a - b);
    }


    public static void main(String[] args) {
        System.out.println("===== OPTIONS =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("===================");
        String input = scanner.nextLine();
        switch(input){
            case "1":
                System.out.println("Enter all numbers comma-separated for sum: ");
                input = scanner.nextLine();
                Integer sum = add(inputToArray(input));
                System.out.println("The result is: " + sum);
                break;

            case "2":
                System.out.println("Enter all numbers comma-separated for subtraction: ");
                input = scanner.nextLine();
                Integer subtracted = subtract(inputToArray(input));
                System.out.println("The result is: " + subtracted);
                break;
        }
    }
}
