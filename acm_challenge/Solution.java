package acm_challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int ranks = 25;
            int stars = 0;
            int consWins = 0;
            String duelRes = br.readLine().trim();

            for (char result : duelRes.toCharArray()) {
                if (result == 'W') {
                    consWins++;
                    stars++;

                    if (ranks >= 6 && ranks <= 25 && consWins >= 3) {
                        stars++;
                    }

                    int starsRequired = starsRequired(ranks);
                    if (stars > starsRequired) {
                        stars -= starsRequired;
                        ranks--;
                    }
                } else {
                    consWins = 0;

                    if (ranks >= 1 && ranks <= 20) {
                        stars--;
                        if (stars < 0) {
                            if (ranks < 20) {
                                ranks++;
                                stars = starsRequired(ranks) - 1;
                            }
                        }
                    }

                    if (ranks == 20 && stars > 0) {
                        stars--;
                    }
                }

                if (ranks < 1) {
                    ranks = 0;
                    break;
                }
            }

            System.out.println(ranks == 0 ? "Archmage" : ranks);
        }
    }

    private static int starsRequired(int ranks) {
        if (ranks >= 21)
            return 2;
        else if (ranks >= 16)
            return 3;
        else if (ranks >= 11)
            return 4;
        else
            return 5;
    }
}
