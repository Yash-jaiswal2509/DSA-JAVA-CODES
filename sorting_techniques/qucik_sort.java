package sorting_techniques;

import java.util.Scanner;

public class qucik_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        qucikSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }

    public static void qucikSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            qucikSort(array, low, pivotIndex - 1);
            qucikSort(array, pivotIndex + 1, high);
        }

    }

    public static int partition(int[] array, int low, int high) {
        int partition = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (array[i] <= partition && i < high) {
                i++;
            }
            while (array[j] > partition && j > low) {
                j--;
            }
            if (i < j) {
                Swap(array, i, j);
            }
        }

        Swap(array, low, j);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("");
        return j;
    }

    public static void Swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
