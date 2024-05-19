package arrays;

import java.util.Scanner;

public class kadane_algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_brutal(arr, n);
        by_better(arr, n);
        by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brutal(int[] arr, int n) {
        // time complexity = O(n^3)
        // space complexity = O(1)
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void by_better(int[] arr, int n) {
        // time complexity = O(n^2)
        // space complexity = O(1)
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }

    public static void by_optimal(int[] arr, int n) {
        // kadane algorithm
        // time complexity = O(n)
        // space complexity = O(1)
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                // for printing sub-array
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(maxSum);
        System.out.print("The subarray is: [ ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
