package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class leaders_in_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_brute(arr, n);
        by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brute(int[] arr, int n) {
        // elements which are greater than every element on the right
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader == true) {
                ans.add(arr[i]);
            }
        }
        for (int value : ans) {
            System.out.print(value + " ");
        }
    }

    public static void by_optimal(int[] arr, int n) {
        // reverse approach
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int max = arr[n - 1];
        ans.add(max);
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                ans.add(max);
            }
        }
        System.out.println("");
        for (int value : ans) {
            System.out.print(value + " ");
        }
    }

}
