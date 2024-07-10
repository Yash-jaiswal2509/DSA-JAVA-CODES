package acm_challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
            char[] digits = s.toCharArray();
            Arrays.sort(digits);
            
            int minDiff = Integer.MAX_VALUE;
            
            int limit = 1 << n;
            for (int mask = 1; mask < limit - 1; mask++) {
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();
                
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) > 0) {
                        s1.append(digits[i]);
                    } else {
                        s2.append(digits[i]);
                    }
                }
                
                if (s1.length() > 0 && s2.length() > 0) {
                    int num1 = Integer.parseInt(s1.toString());
                    int num2 = Integer.parseInt(s2.toString());
                    int currentDiff = Math.abs(num1 - num2);
                    minDiff = Math.min(minDiff, currentDiff);
                }
            }
            
            // Print the result for the current test case
            System.out.println(minDiff);
        }
        
        br.close();
    }
}
