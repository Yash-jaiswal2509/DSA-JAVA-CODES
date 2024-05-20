package arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longest_consecutive_sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        by_brutal(arr, n);
        by_better(arr, n);
        by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brutal(int[] arr, int n) {
        // time complexity ~ O(n^3)
        int longest = 1;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int num = arr[i];
            while (linearSearch(arr, num)) {
                num++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        System.out.println(longest);
    }

    public static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static void by_better(int[] arr, int n) {
        // time complexity = O(nlogn) + O(n)
        sortArray(arr, 0, n - 1);
        int lastSmallest = Integer.MAX_VALUE;
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastSmallest) {
                count++;
                lastSmallest = arr[i];
            } else {
                count = 1;
                lastSmallest = arr[i];
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void by_optimal(int[] arr, int nF) {
        // time complexity = O(2n) + O(n)
        // space complexity = O(n)
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // the while never loops for those who are already in the arr
        // only loops for total n times that's why so it isn't n*n
        // here the 2nd for loop time complexity = O(2n)
        int max = Integer.MIN_VALUE;
        for (int value : set) {
            int count = 1;
            int x = value; // lastSmallest
            if (!set.contains(x - 1)) {
                x = value;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }

    public static void sortArray(int[] arr, int low, int high) {
        // sorting with quick-sort
        if (low < high) {
            int pivotIndex = pivot(arr, low, high);
            sortArray(arr, low, pivotIndex - 1);
            sortArray(arr, pivotIndex + 1, high);
        }

    }

    public static int pivot(int[] arr, int low, int high) {
        int partition = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= partition && i < high) {
                i++;
            }
            while (arr[j] > partition && j > low) {
                j--;
            }
            if (i < j) {
                Swap(arr, i, j);
            }
        }
        Swap(arr, low, j);
        return j;
    }

    public static void Swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
