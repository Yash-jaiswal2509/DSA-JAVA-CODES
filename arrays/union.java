package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class union {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        by_brute(arr1, n1, arr2, n2);
        by_optimal(arr1, n1, arr2, n2);

        scanner.close();
    }

    public static void by_brute(int[] arr1, int n1, int[] arr2, int n2) {
        // time complexity = O(n1logn1 + n2logn2) + O(n1+n2)
        // time complexity = O(n1 + n2) + O(n1+n2)
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n1; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < n2; i++) {
            set.add(arr2[i]);
        }

        for (int value : set)
            System.out.print(value + " ");
    }

    public static void by_optimal(int[] arr1, int n1, int[] arr2, int n2) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                // for first element and then checking if the back element is same or not
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }


        System.out.println("");
        for (int value : union) {
            System.out.print(value + " ");
        }
    }

}