package arrays;

import java.util.Scanner;

public class smallest_largest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Largest number by brute approach " + bruteLargest(arr, n));
        System.out.println("Largest number by optimal approach " + optimalLargest(arr, n));
        System.out.println("Smallest number by brute approach " + bruteSmallest(arr, n));
        System.out.println("Smallest number by optimal approach " + optimalSmallest(arr, n));
        scanner.close();
    }

    // sort the array then last integer will be largest
    public static int bruteLargest(int[] arr, int n) {
        // selection sort
        // time complexity = O(n^2)
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min]) {
                    int temp = arr[j];
                    arr[j] = arr[min];
                    arr[min] = temp;
                }
            }
        }

        int largestElement = arr[n - 1];

        return largestElement;
    }

    public static int optimalLargest(int[] arr, int n) {
        // time complexity = O(n)
        int largestElement = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }

        return largestElement;
    }

    // sort the array then first integer will be smallest
    public static int bruteSmallest(int[] arr, int n) {
        // bubble sort
        // time complexity = O(n^2)
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapNumbers(arr, j, j + 1);
                }
            }
        }
        int smallest = arr[0];
        return smallest;
    }

    public static int optimalSmallest(int[] arr, int n) {
        // time complexity = O(n)
        int smallest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static void swapNumbers(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
