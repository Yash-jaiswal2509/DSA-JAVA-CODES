
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RearrangeArrays {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();
            List<List<Integer>> list = new ArrayList<>();

            while (t-- > 0) {
                int n = scan.nextInt();
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }

                // if (n % 2 == 0) {

                // }

                int sum = 0;
                if (n % 2 == 1) {
                    for (int i = 0; i < n / 2; i++) {
                        int firstEl = arr[i];
                        int secondEl = arr[i + 1];
                        int largeEl = arr[n - 1 - i];

                        sum += largeEl - firstEl;
                        sum += largeEl - secondEl;
                    }
                    if (n > 5) {
                        sum += arr[(n / 2) + 1] - arr[n / 2];
                        sum += arr[n / 2] - arr[(n / 2) - 1];
                    }

                }
                System.out.println(" " + sum);

            }
        }
    }
}