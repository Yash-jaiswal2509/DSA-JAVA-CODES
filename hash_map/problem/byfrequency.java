package hash_map.problem;

import java.util.Scanner;

public class byfrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int arrayNumber = scanner.nextInt();
            arr[i] = arrayNumber;
        }

        int[] hash = new int[68];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int max = 1;
        int maxNumberIndex = 0;
        int minNumberIndex = 0;
        for (int i = 0; i < 68; i++) {
            if (hash[i] > max) {
                max = hash[i];
                maxNumberIndex = i;
            }
        }

        int min = max;
        for (int i = 0; i < 68; i++) {
            if (hash[i] < min && hash[i] != 0) {
                min = hash[i];
                minNumberIndex = i;
            }
        }
        System.out.println(maxNumberIndex + " " + minNumberIndex);
        scanner.close();
    }
}
