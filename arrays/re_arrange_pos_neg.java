package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class re_arrange_pos_neg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // by_brutal(arr, n);
        by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brutal(int[] arr, int n) {
        // time complexity = O(2n)
        // space complexity = O(n)
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                neg.add(arr[i]);
            } else {
                pos.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            arr[i * 2] = pos.get(i);
            arr[i * 2 + 1] = neg.get(i);
        }

        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    public static void by_optimal(int[] arr, int n) {
        // time complexity = O(n)
        // space complexity = O(n)
        int[] ans = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            } else if (arr[i] >= 0) {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }

        System.out.println("");
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("]");

    }
}
