import java.io.*;
import java.util.*;

public class a {
    static FastReader in = new FastReader();
    static final Random random = new Random();
    static long mod = 1000000007;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String args[]) throws IOException {
        int t = in.nextInt();
        StringBuilder res = new StringBuilder();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int ans = 0;
            List<Integer> list = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                list.add(i);
                list.add(i);
            }
            list.add(n);

            Collections.sort(list, Collections.reverseOrder());

            for (int val : list) {
                if (k == 0)
                    break;

                int chip = min(val, k);
                k -= chip;
                ans++;
            }

            res.append(ans).append("\n");
        }
        print(res);
    }

    static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }

    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static <E> void print(E res) {
        System.out.println(res);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static int abs(int a) {
        if (a < 0)
            return -1 * a;
        return a;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readintarray(int n) {
            int res[] = new int[n];
            for (int i = 0; i < n; i++)
                res[i] = nextInt();
            return res;
        }

        long[] readlongarray(int n) {
            long res[] = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = nextLong();
            return res;
        }
    }

}
