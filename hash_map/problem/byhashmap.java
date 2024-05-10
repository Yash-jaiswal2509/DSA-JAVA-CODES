package hash_map.problem;

import java.util.*;

public class byhashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // creating hashmp
        Map<Integer, Integer> hash = new HashMap<>();

        // assigning the given inputs to the hash in the form of element and value
        for (int i = 0; i < n; i++) {
            int hashNumber = scanner.nextInt();
            if (hash.containsKey(hashNumber)) {
                hash.put(hashNumber, hash.get(hashNumber) + 1);
            } else {
                hash.put(hashNumber, 1);
            }
        }

        int maxFreq = 0;
        int minFreq = n;
        int maxNumber = 0;
        int minNumber = 0;

        // iterating through each value
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxNumber = entry.getKey();
                maxFreq = entry.getValue();
            }

            if (entry.getValue() < minFreq) {
                minNumber = entry.getKey();
                minFreq = entry.getValue();
            }
        }

        System.out.println("Maximum frequency of number " + maxNumber);
        System.out.println("Minimum frequency of number " + minNumber);

        scanner.close();
    }
}
