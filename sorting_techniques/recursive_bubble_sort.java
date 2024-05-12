package sorting_techniques;

import java.util.Scanner;

public class recursive_bubble_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        bubble_sort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }

    public static void bubble_sort(int[] arr, int arrSize) {
        if (arrSize == 0)
            return;

        for (int i = 0; i < arrSize - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                swapNumbers(arr, i, i + 1);
            }
        }

        bubble_sort(arr, arrSize - 1);
    }

    public static void swapNumbers(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
