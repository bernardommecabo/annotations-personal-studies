package org.bernardomecabo.ProgrammingLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOExamples {
    public static void outputExample() {
        //EXAMPLE OUTPUT
        String product1 = "Computer";
        String product2 = "Office desk";
        int age = 30;
        int code = 5290;
        char gender = 'F';
        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.println("Products:");
        System.out.println(product1 + ", which price is $ " + price1);
        System.out.println(product2 + ", which price is $ " + price2);
        System.out.println("Record: " + age + " years old, code " + code + " and gender: " + gender);
        System.out.printf("Measure with eight decimal places: %.8f%n", measure);
        System.out.printf("Rounded (three decimal places): %.3f%n", measure);
        System.out.println("US decimal point: " + measure);
    }

    public static void inputExample(String input) {
        System.out.println("Hello, " + input + "!");
    }

    public static void bhaskaraSolver(String equation) {
        String regex = "([+-]?\\d*)\\s*x\\^2\\s*([+-]?\\s*\\d*)\\s*x\\s*([+-]?\\s*\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation);

        if (matcher.find()) {
            double a = parseCoeficiente(matcher.group(1), true);
            double b = parseCoeficiente(matcher.group(2), false);
            double c = parseCoeficiente(matcher.group(3).replaceAll("\\s+", ""), false);

            System.out.println("\nCoefficients:");
            System.out.println("A = " + a);
            System.out.println("B = " + b);
            System.out.println("C = " + c);

            double delta = Math.pow(b, 2) - 4 * a * c;
            System.out.println("Delta: " + delta);
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("X1: " + x1);
            System.out.println("X2: " + x2);

        } else {
            System.out.println("Erro: Formato de equação inválido. Use o padrão 'ax^2 + bx + c = 0'.");
        }
    }

    private static double parseCoeficiente(String grupo, boolean isA) {
        if (grupo == null || grupo.trim().isEmpty() || grupo.equals("+")) {
            return 1.0;
        }
        if (grupo.equals("-")) {
            return -1.0;
        }
        return Double.parseDouble(grupo.replaceAll("\\s+", ""));
    }
}
