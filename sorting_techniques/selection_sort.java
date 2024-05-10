package sorting_techniques;

import java.util.Scanner;

public class selection_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int integer = scanner.nextInt();
            arr[i] = integer;
        }

        for (int i = 0; i < n - 1; i++) {// This is for no. of steps
            int minIndex = i;
            for (int j = i; j < n; j++) {// For iterating through arr
                if (arr[j] < arr[minIndex]) {
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
