package arrays;

import java.util.Scanner;

public class check_sortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count = count + 1;
                break;
            }
        }

        if (count != 0) {
            System.out.println("Array not sorted");
        } else {
            System.out.println("Array Sorted");
        }
        scanner.close();
    }
}
