import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //#1
        Stream<Integer> stream = Stream.of(3, 7, 4, 9, 1, 6);

        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("Min: %s, Max: %s%n", x, y)
        );

        stream.close();

        //#2
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,10,12,14,15));

        System.out.println("Count of even element: " + evenNumber(list));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static int evenNumber (List <Integer> numbers) {
        return (int) numbers.stream()
                .filter(s -> s % 2 == 0).count();
    }
}