package arrays;

import java.util.Scanner;

public class sort_zero_one_two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // by_brutal(arr, n);
        by_better(arr, n);
        // by_optimal(arr, n);
        scanner.close();
    }

    public static void by_brutal(int[] arr, int n) {
        // using quick sort
        // time complexity = O(nlogn)
        // space complexity = O(nlogn)
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partitionIndex(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public static int partitionIndex(int[] arr, int low, int high) {

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

        return j;

    }

    public static void Swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void by_better(int[] arr, int n) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // time complexity = O(2n)

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;
        while (index < n) {
            if (index < count0) {
                arr[index] = 0;
            }
            if (index >= count0 && index < count0 + count1) {
                arr[index] = 1;
            }
            if (index >= count0 + count1 && index < count0 + count1 + count2) {
                arr[index] = 2;
            }
            index++;
        }

        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void by_optimal(int[] arr, int n) {
        // Dutch national flag algorithm

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (low <= mid && mid < high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
