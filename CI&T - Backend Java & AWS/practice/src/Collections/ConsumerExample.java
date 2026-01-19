package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> consumer = i -> System.out.println(i);

        list.forEach(consumer);
    }
}
