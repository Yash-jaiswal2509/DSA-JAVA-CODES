package hash_map;
import java.util.Scanner;

public class hash_array {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] hash = new int[68];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; m++) {
            int x = scanner.nextInt();
            System.out.println(hash[x]);
        }

        scanner.close();
    }
}
