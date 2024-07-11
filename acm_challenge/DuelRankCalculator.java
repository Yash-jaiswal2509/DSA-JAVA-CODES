import java.util.*;

public class DuelRankCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            String duelRes = scanner.nextLine();
            System.out.println(calcRank(duelRes));
        }
        scanner.close();
    }

    private static String calcRank(String duelRes) {
        int rank = 25;
        int stars = 0;
        int consWins = 0;

        int[] requiredStars = new int[] { 2, 3, 4, 5 };

        for (char duel : duelRes.toCharArray()) {
            if (duel == 'W') {
                consWins++;
                stars++;

                if (rank >= 6 && consWins >= 3) {
                    stars++;
                }

                int requiredStarsForRank = getRequiredStars(rank, requiredStars);
                if (stars > requiredStarsForRank) {
                    stars -= requiredStarsForRank;
                    rank--;
                    if (rank == 0) {
                        return "Archmage";
                    }
                }
            } else {
                consWins = 0;
                if (rank >= 1 && rank <= 20) {
                    stars--;
                    if (stars < 0 && rank < 20) {
                        rank++;
                        stars = getRequiredStars(rank, requiredStars) - 1;
                    } else if (stars < 0 && rank == 20) {
                        stars = 0;
                    }
                }
            }
        }

        return String.valueOf(rank);
    }

    private static int getRequiredStars(int rank, int[] requiredStars) {
        if (rank >= 21) {
            return requiredStars[0];
        } else if (rank >= 16) {
            return requiredStars[1];
        } else if (rank >= 11) {
            return requiredStars[2];
        } else {
            return requiredStars[3];
        }
    }
}
