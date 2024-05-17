package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class intersection {
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

        by_brutal(arr1, n1, arr2, n2);
        by_optimal(arr1, n1, arr2, n2);

        scanner.close();
    }

    public static void by_brutal(int[] arr1, int n1, int[] arr2, int n2) {
        // time complexity = O(n1*n2)
        // space complexity = O(n2)
        int[] vis = new int[n2];
        Arrays.fill(vis, 0);
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && vis[j] == 0) {
                    vis[j] = 1;
                    temp.add(arr1[i]);
                    break; // to save time
                }

                if (arr2[j] > arr1[i]) // to save time
                    break;
            }
        }

        for (int j = 0; j < temp.size(); j++) {
            System.out.print(temp.get(j) + " ");
        }
    }

    public static void by_optimal(int[] arr1, int n1, int[] arr2, int n2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] == arr2[j]) {
                temp.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
        }

        System.out.println(" ");

        for (int value : temp) {
            System.out.print(value + " ");
        }
    }
}
