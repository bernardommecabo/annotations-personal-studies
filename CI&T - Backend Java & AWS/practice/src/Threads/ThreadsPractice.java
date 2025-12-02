package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Runnable;
import java.lang.Thread;

public class ThreadsPractice {
    private static List<Integer> numbers = new ArrayList<>();
    private static final Scanner  scanner = new Scanner(System.in);

    private static synchronized void addNumber(int number) {
        numbers.add(number);
    }

    private static synchronized void removeNumber(int number) {
        numbers.remove(number);
    }

    private static synchronized void show (){
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable application = () -> {
            System.out.println("Chose an option");
            String answ = scanner.nextLine();
            while (answ != "4"){
                if (answ == "1") {
                    System.out.println("Enter number");
                    Integer numberAdd = scanner.nextInt();
                    addNumber(numberAdd);
                }
                if (answ == "2") {
                    System.out.println("Enter number");
                    Integer numberRemove = scanner.nextInt();
                    removeNumber(numberRemove);
                }
                if (answ == "3") {}
                    show();
            }
        };
        new Thread(application).start();
    }
}
