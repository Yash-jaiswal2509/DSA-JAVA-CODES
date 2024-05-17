package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class number_appear_once {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_brute(arr, n);
        by_better(arr, n);
        by_optimal(arr);
        scanner.close();
    }

    public static void by_brute(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1)
                System.out.println(arr[i]);
        }
    }

    public static void by_better(int[] arr, int n) {
        // just remember you can use hashing two ways:
        // 1. hash with array
        // 2. using HashMap
        // time complexity = O(3n)

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], 2);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println(entry.getKey());
        }
    }

    public static void by_optimal(int[] arr) {
        int n = arr.length;
        int XOR = 0;
        for (int i = 0; i < n; i++) {
            XOR = XOR ^ arr[i];
        }

        System.out.println(XOR);
    }

}
