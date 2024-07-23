// package codechef_div_nine_six_one;

import java.util.Arrays;
import java.util.Scanner;

public class eautifulbouquet {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                long m = sc.nextLong();
                int[] petals = new int[n];
                for (int j = 0; j < n; j++) {
                    petals[j] = sc.nextInt();
                }
                result.append(maxPetals(n, m, petals)).append("\n");
            }

            System.out.print(result.toString());
        }
    }

    private static long maxPetals(int n, long m, int[] petals) {
        Arrays.sort(petals);
        long maxPetals = 0;
        long currentPetals = 0;
        long currentCost = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentPetals += petals[right];
            currentCost += petals[right];
            while (currentCost > m || (right > left && petals[right] - petals[left] > 1)) {
                currentPetals -= petals[left];
                currentCost -= petals[left];
                left++;
            }
            maxPetals = Math.max(maxPetals, currentPetals);
        }
        return maxPetals;
    }
}
