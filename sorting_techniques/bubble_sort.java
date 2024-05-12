package sorting_techniques;

import java.util.Scanner;

public class bubble_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // for (int i = 0; i <= n - 2; i++) {//one element will always remain
        // for (int j = i; j <= n - 2; j++) {
        // if (arr[j] > arr[j + 1]) {
        // int temp = arr[j + 1];
        // arr[j + 1] = arr[j];
        // arr[j] = temp;
        // }
        // }
        // }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {// here i<n-1 but it isn't required
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            // for (int k = 0; k < n; k++) {
            // System.out.print(arr[k] + " ");
            // }
            // System.out.println("");
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
