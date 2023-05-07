import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1562 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_000;
        int N = Integer.parseInt(br.readLine());
        long[][][] DP = new long[N + 1][10][1 << 10];
        for (int j = 1; j <= 9; j++) {
            DP[1][j][1 << j] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 1; k < (1 << 10); k++) {
                    int bit = (1 << j) | k;
                    if (j == 0) DP[i][j][bit] = (DP[i][j][bit] + DP[i - 1][j + 1][k]) % MOD;
                    else if (j == 9) DP[i][j][bit] = (DP[i][j][bit] + DP[i - 1][j - 1][k]) % MOD;
                    else DP[i][j][bit] = (DP[i][j][bit] + DP[i - 1][j - 1][k] + DP[i - 1][j + 1][k]) % MOD;
                }
            }
        }
        long answer = 0;
        for (int j = 0; j <= 9; j++) {
            answer += DP[N][j][(1 << 10) - 1];
            answer %= MOD;
        }
        System.out.println(answer);
    }

}