import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicPermutation {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt(); // Number of test cases
            while (T-- > 0) {
                int n = sc.nextInt(); // Number of elements in the permutation
                
                // Result collection
                List<Integer> results = new ArrayList<>();
                
                // Initialize the permutation from 1 to n
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i + 1;
                }
                
                while (true) {
                    // Alice's turn: maximize the magic value
                    results.add(calculateMagicValue(a, true));
                    decrementArray(a);
                    if (isAllZero(a)) break;
                    
                    // Bob's turn: minimize the magic value
                    results.add(calculateMagicValue(a, false));
                    decrementArray(a);
                    if (isAllZero(a)) break;
                }
                
                // Print results
                System.out.println(results.size());
                for (int result : results) {
                    System.out.print(result + " ");
                }
                System.out.println();
            }
        } // Number of test cases
    }
    
    private static int calculateMagicValue(int[] a, boolean maximize) {
        if (maximize) {
            Arrays.sort(a);
            int n = a.length;
            int[] temp = new int[n];
            int left = 0, right = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    temp[i] = a[left++];
                } else {
                    temp[i] = a[right--];
                }
            }
            return computeMagicValue(temp);
        } else {
            Arrays.sort(a);
            return computeMagicValue(a);
        }
    }
    
    private static int computeMagicValue(int[] a) {
        int magic = 0;
        for (int i = 0; i < a.length - 1; i++) {
            magic += Math.abs(a[i] - a[i + 1]);
        }
        return magic;
    }
    
    private static void decrementArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                a[i]--;
            }
        }
    }
    
    private static boolean isAllZero(int[] a) {
        for (int num : a) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
