package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class two_sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_optimal(arr, n, target);

        int[] indexByBrute = by_brute(arr, n, target);
        for (int i = 0; i < indexByBrute.length; i++) {
            System.out.print(indexByBrute[i] + " ");
        }
        System.out.println("");
        int[] indexByBetter = by_better(arr, n, target);
        for (int i = 0; i < indexByBetter.length; i++) {
            System.out.print(indexByBetter[i] + " ");
        }

        scanner.close();
    }

    public static int[] by_brute(int[] arr, int n, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public static int[] by_better(int[] arr, int n, int target) {
        // time complexity = O(n*logn) in rare cases for unordered map searching of
        // O(n^2)
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                ans[0] = i;
                ans[1] = j;
                return ans;
            } else {
                map.put(arr[i], i);
            }
        }

        return ans;
    }

    public static void by_optimal(int[] arr, int n, int target) {
        // two pointer approach
    }




}
