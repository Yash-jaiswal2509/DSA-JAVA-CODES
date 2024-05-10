package hash_map;

import java.util.HashMap;
import java.util.Scanner;

public class hash_map {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int arrayNumber = scanner.nextInt();
            if (hash.containsKey(arrayNumber)) {
                hash.put(arrayNumber, hash.get(arrayNumber) + 1);
            } else {
                // for every first integer, the value will be 1 and else gets executed
                hash.put(arrayNumber, 1);
            }
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int searchNumbers = scanner.nextInt();

            if (hash.containsKey(searchNumbers)) {
                System.out.println(searchNumbers + "->" + hash.get(searchNumbers));
            } else {
                System.out.println(searchNumbers + "->" + 0);
            }
        }
        scanner.close();
    }
}
