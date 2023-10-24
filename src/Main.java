import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IntStream.iterate(  'A' , i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                //.skip(5)
                //.dropWhile(i->i <= 'E')
                //.takeWhile(i -> i < 'a')
                .forEach(d -> System.out.printf(" %c ", d));

        System.out.println();
        Random random =  new Random();
        Stream.generate(() -> random.nextInt('A', (int)'Z' +1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf(" %c ", d));

        System.out.println();
        int maxSeat = 100;
        int SeatsInRow =10;
        var stream = Stream.iterate(0, i -> i < maxSeat, i-> i+1)
                .map(i -> new Seat((char) ('A' + i / SeatsInRow),
                         i % SeatsInRow + 1))
//                        .mapToDouble(Seat::price);
                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));

        stream.forEach(System.out::println);

    }
}