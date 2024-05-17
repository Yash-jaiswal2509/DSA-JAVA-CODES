package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class longest_subarray_sum_k {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_brute(arr, n, k);
        by_better(arr, n, k);
        int maxLen = by_optimal(arr, n, k);
        System.out.print(maxLen);
        scanner.close();
    }

    public static void by_brute(int[] arr, int n, int k) {
        // time complexity = O(n^2)
        int length = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        System.out.println(length);
    }

    public static void by_better(int[] arr, int n, long k) {
        // map is a interface while hashmap is a class
        Map<Long, Integer> hash = new HashMap<Long, Integer>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            long prefixSum = sum - k;
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (hash.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - hash.get(prefixSum));
            }
            if (!hash.containsKey(prefixSum)) {
                hash.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }

    public static int by_optimal(int[] arr, int n, int k) {
        /*
         * time complexity = O(2n) not O(n^2) because the inner loop only moves for n
         * times in total
         * when there are negaitve numbers it doesn't wokrs then better approach is the
         * optimal approach
         */

        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {

            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) {
                sum += arr[right];
            }
        }

        return maxLen;
    }
}
