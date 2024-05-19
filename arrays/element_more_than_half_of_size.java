package arrays;

import java.util.Scanner;

public class element_more_than_half_of_size {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int brutal = by_brutal(arr, n);
        System.out.println(brutal);
        int better = by_better(arr, n);
        System.out.println(better);
        int optimal = by_optimal(arr, n);
        System.out.println(optimal);

        scanner.close();
    }

    public static int by_brutal(int[] arr, int n) {
        // time comlexity = O(n^2)
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int by_better(int[] arr, int n) {
        // hashing
        // time complexity = O(n) + O(n)
        // space complexity = O(n)

        int[] hash = new int[n];
        for (int i = 0; i < hash.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[arr[i]] > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int by_optimal(int[] arr, int n) {
        // Moore's voring algorithm
        // time complexity = O(n) + O(n){if it's given that there is a chance of no
        // element more than n/2}
        // space complexity = O(1)
        int count = 0;
        int element = -1;
        for (int j = 0; j < arr.length; j++) {
            if (count == 0) {
                count = 1;
                element = arr[j];
            } else if (element == arr[j]) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count1++;
            }
        }

        if (count1 > n / 2) {
            return element;
        }

        return -1;
    }
}
