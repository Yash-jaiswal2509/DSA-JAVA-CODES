package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class find_missing_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N - 1; i++) {
            arr[i] = scanner.nextInt();
        }

        int missingNumberByBrute = by_brute(arr, N);
        System.out.print(missingNumberByBrute);
        int missingNumberByBetter = by_better(arr, N);
        System.out.println(missingNumberByBetter);
        int missingNumberByOptimal1 = by_optimal1(arr, N);
        System.out.println(missingNumberByOptimal1);
        int missingNumberByOptimal2 = by_optimal2(arr, N);
        System.out.println(missingNumberByOptimal2);
        scanner.close();
    }

    public static int by_brute(int[] arr, int N) {
        // through linear search
        // time comlpexity = O(n^2)
        // space comlpexity = O(1)
        for (int i = 1; i <= N; i++) {
            int flag = 0;
            for (int j = 0; j < N - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;// no need t iterate remaining element
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        // only to avoid warnings
        return -1;
    }

    public static int by_better(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 1 2 3 4 5 6 7 8 9 10 -> key
        // 1 _ 1 1 1 1 1 1 1 1 -> value
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                map.put(arr[i], 1);
        }
        System.out.println(" ");
        // for (int value : map.values()) {
        // System.out.print(value + " ");
        // }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }

    public static int by_optimal1(int[] arr, int n) {
        // time complexity = O(n)
        int totalSum = 0;
        int arrSum = 0;
        totalSum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        return totalSum - arrSum;
    }

    public static int by_optimal2(int[] arr, int n) {
        // using XOR
        // time complexity = O(n)
        int XOR1 = 0;
        int XOR2 = 0;
        for (int i = 0; i < n; i++) {
            XOR1 = XOR1 ^ (i + 1);
            XOR2 = XOR2 ^ arr[i];
        }
        return XOR1^XOR2;
    }

}
