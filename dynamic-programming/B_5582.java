import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5582 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[][] DP = new int[s1.length + 1][s2.length + 1];
        long answer = 0;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                    answer = Math.max(answer, DP[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}