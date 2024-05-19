package arrays;

import java.util.Scanner;

public class stock_buy_sell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        by_brutal(arr, n);
        by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brutal(int[] arr, int n) {
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxDiff = Math.max(maxDiff, arr[j] - arr[i]);
                }
            }
        }
        System.out.println(maxDiff);
    }

    public static void by_optimal(int[] arr, int n) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        System.out.println(maxProfit);
    }
}
