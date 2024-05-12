package sorting_techniques;

import java.util.ArrayList;
import java.util.Scanner;

public class merge_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Whatever we are doing here is with indexes not array
    public static void mergeSort(int[] array, int low, int high) {
        // only equal is required but > is for safety
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    // here we are changing the array's element
    private static void merge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
                temp.add(array[left]);
                left++;
            }
            if (array[left] > array[right]) {
                temp.add(array[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(array[left]);
            left++;
        }
        while (right <= high) {
            temp.add(array[right]);
            right++;
        }

        System.out.println(temp);

        for (int i = low; i <= high; i++) {
            array[i] = temp.get(i - low);
        }
    }
}
