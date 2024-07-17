import java.util.Scanner;

public class ChessboardColoring {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        System.out.println(countBeautifulColorings(n, k));
    }

    public static int countBeautifulColorings(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + 2 * dp[i - 1][j - 1]) % MOD;
                }
                if (j > 1) {
                    dp[i][j] = (dp[i][j] + 2 * dp[i - 1][j - 2]) % MOD;
                }
                if (i > 1 && j > 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 2][j - 2]) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}
