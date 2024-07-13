import java.util.Scanner;

public class FashionFusion {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                long M = scanner.nextLong();

                int[] swa = new int[n];
                for (int i = 0; i < n; i++) {
                    swa[i] = scanner.nextInt();
                }

                long res = 0;
                long operations = 0;
                int start = 0;
                int maxVal = swa[0];

                for (int end = 0; end < n; end++) {
                    if (swa[end] < maxVal) {
                        operations += maxVal - swa[end];
                    } else {
                        maxVal = swa[end];
                    }

                    while (operations > M) {
                        if (swa[start] < maxVal) {
                            operations -= maxVal - swa[start];
                        }
                        start++;
                        if (start <= end) {
                            maxVal = swa[start];
                            for (int k = start + 1; k <= end; k++) {
                                if (swa[k] > maxVal) {
                                    maxVal = swa[k];
                                }
                            }
                            operations = 0;
                            for (int k = start; k <= end; k++) {
                                if (swa[k] < maxVal) {
                                    operations += maxVal - swa[k];
                                }
                            }
                        }
                    }

                    res += end - start + 1;
                }

                System.out.println(res);
            }
        }
    }
}
