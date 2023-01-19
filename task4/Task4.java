package main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input absolute path to file :");
        String path = scanner.next();
        FileReader fileReader = new FileReader(path);
        List<Long> numbers = createArray(new Scanner(fileReader));

        System.out.println(calculateAllSteps(numbers));
    }

    private static long calculateAllSteps(List<Long> numbers) {
        long averageValues = getAverageValues(numbers);
        long maximumApproximateAverage = numbers.stream()
                .min(Comparator.comparingLong(number -> Math.abs(number - averageValues)))
                .orElseThrow(NoSuchElementException::new);
        return numbers.stream().mapToLong(p -> calculateSteps(p, maximumApproximateAverage)).sum();
    }

    private static long getAverageValues(List<Long> numbers) {
        return Math.round(numbers.stream()
                .mapToDouble(p -> p)
                .average()
                .orElseThrow(NoSuchElementException::new));
    }

    private static long calculateSteps(long value, long averageValues) {
        return Math.abs(value - averageValues);
    }

    private static List<Long> createArray(Scanner scanner) {
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            numbers.add(scanner.nextLong());
        }
        return numbers;
    }
}
