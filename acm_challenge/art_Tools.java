import java.util.*;

public class art_Tools {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int[] tools = new int[100001];
            for (int i = 0; i < n * k; i++) {
                int toolNum = scan.nextInt();
                tools[toolNum]++;
            }

            int[] favTools = new int[100001];
            int[] art = new int[n];
            for (int i = 0; i < n; i++) {
                art[i] = scan.nextInt();
                favTools[art[i]]++;
            }

            int[] satLevel = new int[k];
            for (int i = 0; i < k; i++) {
                satLevel[i] = scan.nextInt();
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 1; i <= 100000; i++) {
                if (favTools[i] > 0) {
                    int totFavTools = tools[i];
                    int totartFav = favTools[i];

                    int[] portions = new int[totartFav];
                    int index = 0;

                    while (totFavTools > 0) {
                        portions[index % totartFav]++;
                        totFavTools--;
                        index++;
                    }

                    for (int portion : portions) {
                        if (portion > 0) {
                            pq.add(portion);
                        }
                    }
                }
            }

            int totSat = 0;
            while (!pq.isEmpty()) {
                int t = pq.poll();
                totSat += satLevel[Math.min(t, k) - 1];
            }

            System.out.println(totSat);
        }
    }
}
