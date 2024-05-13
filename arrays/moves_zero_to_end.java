package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class moves_zero_to_end {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // move_by_brute(arr, n);
        move_by_optimal(arr, n);

        scanner.close();
    }

    public static void move_by_brute(int[] arr, int n) {
        // time complexity = O(2n)
        // space complexity = O(n)
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                temp.add(arr[i]);
            }
        }
        System.out.println(temp);
    }

    public static void move_by_optimal(int[] arr, int n) {
        // time complexity = O(2n)
        // space complexity = O(1)
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                SwapNumbers(arr, j, i);
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void SwapNumbers(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
