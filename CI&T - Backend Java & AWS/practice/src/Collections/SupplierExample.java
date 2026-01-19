package Collections;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello moto";

        List<String> list = Stream.generate(supplier)
                .limit(5)
                .toList();

        list.forEach(System.out::println);
    }
}
