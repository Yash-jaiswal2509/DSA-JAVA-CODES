package arrays;

import java.util.Scanner;

public class maximum_consecutive_one {
    public static void main(String[] args) {
        //optimal solution
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        System.out.print(max);
        scanner.close();
    }
}
