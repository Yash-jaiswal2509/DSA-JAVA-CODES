import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RearrangeArrays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] p = new int[n];
            int[] q = new int[n];

            String[] pInput = br.readLine().trim().split(" ");
            String[] qInput = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(pInput[i]);
                q[i] = Integer.parseInt(qInput[i]);
            }

            Arrays.sort(p);
            Arrays.sort(q);

            boolean isPos = true;

            for (int i = 0; i < n; i++) {
                if (p[i] > q[i]) {
                    isPos = false;
                    break;
                }
            }

            if (isPos) {
                isPos = helper(p);
            }

            System.out.println(isPos ? "YES" : "NO");
        }
    }

    private static boolean helper(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(freqMap.values());
        return maxFreq <= (n + 1) / 2;
    }
}




// Exception in thread "main" java.util.InputMismatchException: For input string: "29203464463"
// 	at java.base/java.util.Scanner.nextInt(Scanner.java:2264)
// 	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
// 	at TestClass.main(TestClass.java:11)