import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                long[][] arr = new long[n][m];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = in.nextLong();
                    }
                }

                long ans = 0L;
                for (int j = 0; j < m; j++) {
                    List<Long> list = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        list.add(arr[i][j]);
                    }
                    Collections.sort(list);

                    for (int i = 0; i < n; i++) {
                        ans += i * list.get(i) - (n - 1 - i) * list.get(i);
                    }
                }

                System.out.println(ans);
            }
        }
    }
}
