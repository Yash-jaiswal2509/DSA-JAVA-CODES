package arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class remove_duplicates {
    public static void main(String[] args) {
        // remove duplicates from sorted arrays
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        usingBrute(arr, n);
        int k = usingOptimal(arr, n);
        System.out.println(k);
        scanner.close();
    }

    public static void usingBrute(int[] arr, int n) {
        // Time complextity = O(nlogn) of set
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());
    }

    public static int usingOptimal(int[] arr, int n) {
        // Time complexity = O(n)
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
