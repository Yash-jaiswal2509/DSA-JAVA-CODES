import java.util.Scanner;

public class CastleTowerAdventures {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();
            
            int[][] dp = new int[k + 1][n + 1];
            dp[0][a] = 1;

            for (int step = 1; step <= k; step++) {
                int[] preSum = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    preSum[i] = (preSum[i - 1] + dp[step - 1][i]) % MOD;
                }
                
                for (int i = 1; i <= n; i++) {
                    if (i == b) continue;
                    
                    int left = Math.max(1, i - (Math.abs(i - b)));
                    int right = Math.min(n, i + (Math.abs(i - b)));
                    
                    dp[step][i] = (preSum[right] - preSum[left - 1] + MOD) % MOD;
                    dp[step][i] = (dp[step][i] - dp[step - 1][i] + MOD) % MOD;
                }
            }

            long result = 0;
            for (int i = 1; i <= n; i++) {
                if (i != b) {
                    result = (result + dp[k][i]) % MOD;
                }
            }

            System.out.println(result);
        }
    }
}
