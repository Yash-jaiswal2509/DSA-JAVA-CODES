package arrays;

import java.util.ArrayList;
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
        usingOptimal(arr, n);

        scanner.close();
    }

    public static void usingBrute(int[] arr, int n) {
        // Time complextity = O(nlogn) of set
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        System.out.println("This is done by using set which doesn't takes duplicates " + set);
    }

    public static void usingOptimal(int[] arr, int n) {
        // Time complexity = O(n)
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                array.add(arr[i]);
            }
        }

        System.out.println(array);
    }
}
