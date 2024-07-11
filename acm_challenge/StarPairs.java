
import java.util.Scanner;

public class StarPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];
        int maxElement = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }

        int[] frequency = new int[maxElement + 1];
        for (int i = 0; i < n; i++) {
            frequency[array[i]]++;
        }

        int starPairCount = 0;
        for (int i = 1; i <= maxElement; i++) {
            if (frequency[i] > 0) {
                for (int j = 2 * i; j <= maxElement; j += i) {
                    // jinka nhi hai vo 0 hai, rest have some, they are added
                    starPairCount += frequency[i] * frequency[j];
                }
                if (frequency[i] > 1) {
                    starPairCount += (frequency[i] * (frequency[i] - 1)) / 2;
                }
            }
            // O(n^2) -> O(nlogn)
        }

        System.out.println(starPairCount);

        sc.close();
    }
}
