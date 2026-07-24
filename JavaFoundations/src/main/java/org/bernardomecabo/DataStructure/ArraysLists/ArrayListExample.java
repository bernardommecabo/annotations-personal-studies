package org.bernardomecabo.DataStructure.ArraysLists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
     static void main() {
        List<String> list = new ArrayList<>();

        list.add("Abner");
        list.add("Aila");
        list.add("Bernas");
        list.add("NOCAP");
        list.add("Bernas NOCAP");

        list.stream()
                .filter(s -> s.charAt(0) == 'B')
                .forEach(System.out::println);

        System.out.println("----------------------------");

        List<String> results = list.stream()
                .filter(s -> s.contains("NOCAP"))
                .toList();

        results.forEach(System.out::println);

        System.out.println("----------------------------");

        list.forEach(System.out::println);
    }
}
