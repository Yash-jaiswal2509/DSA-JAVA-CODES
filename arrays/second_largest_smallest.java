package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class second_largest_smallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Second largest number by brute approach " + bruteSecondLargest(arr, n));
        System.out.println("Second largest number by better approach " + betterSecondLargest(arr, n));
        System.out.println("Second largest number by optimal approach " + optimalSecondLargest(arr, n));
        System.out.println("Second smallest number by brute approach " + bruteSecondSmallest(arr, n));
        System.out.println("Second smallest number by better approach " + betterSecondSmallest(arr, n));
        System.out.println("Second smallest number by optimal approach " + optimalSecondSmallest(arr, n));
        scanner.close();
    }

    public static int bruteSecondLargest(int[] arr, int n) {
        // sorting the array, then checking for duplication
        // using insertion sort
        // time complexity = O(n^2)
        int secondLargest = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] >= arr[j]) {
                SwapNumbers(arr, j - 1, j);
                j--;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i - 1] < arr[i]) {
                secondLargest = arr[i - 1];
                break;
            }
        }
        return secondLargest;
    }

    public static int betterSecondLargest(int[] arr, int n) {
        // non negative numbers in the array
        // time complexity = O(2n)
        int secondLargest = -1;
        int largest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if ((arr[i] > secondLargest) && (arr[i] < largest)) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static int optimalSecondLargest(int[] arr, int n) {
        // time complexity = O(n)
        int secondLargest = -1;
        int largest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
        }
        return secondLargest;
    }

    public static int bruteSecondSmallest(int[] arr, int n) {
        // sorting the array using merge-sort
        mergeSort(arr, 0, n - 1);
        int secondSmallest = arr[1];
        return secondSmallest;
    }

    public static int betterSecondSmallest(int[] arr, int n) {
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < secondSmallest && arr[i] > smallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static int optimalSecondSmallest(int[] arr, int n) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && secondSmallest != smallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static void SwapNumbers(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            }

            if (arr[left] > arr[right]) {
                temp.add(arr[right]);
                right++;
            }

            if (left <= mid) {
                temp.add(arr[left]);
                left++;
            }

            if (right <= high) {
                temp.add(arr[right]);
                right++;
            }
        }
    }
}
