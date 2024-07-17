import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AliceBobGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        List<List<Integer>> allResults = new ArrayList<>();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // value of n for this test case
            allResults.add(playGame(n));
        }

        // Print results
        for (List<Integer> results : allResults) {
            System.out.println(results.size());
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static List<Integer> playGame(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(n - i); // initial permutation: [n, n-1, ..., 1]
        }

        List<Integer> notedValues = new ArrayList<>();
        boolean aliceTurn = true;

        while (!allZero(numbers)) {
            if (aliceTurn) {
                Collections.sort(numbers); // Alice maximizes the magic value
            } else {
                Collections.sort(numbers, Collections.reverseOrder()); // Bob minimizes the magic value
            }

            notedValues.add(calculateMagicValue(numbers));
            decrementAll(numbers);
            aliceTurn = !aliceTurn;
        }

        return notedValues;
    }

    private static boolean allZero(List<Integer> numbers) {
        for (int number : numbers) {
            if (number != 0) {
                return false;
            }
        }
        return true;
    }

    private static void decrementAll(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                numbers.set(i, numbers.get(i) - 1);
            }
        }
    }

    private static int calculateMagicValue(List<Integer> numbers) {
        int magicValue = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            magicValue += Math.abs(numbers.get(i) - numbers.get(i + 1));
        }
        return magicValue;
    }
}
