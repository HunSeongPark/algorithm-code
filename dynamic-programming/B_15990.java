import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15990 {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        long[][] DP = new long[100001][4];
        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            DP[i][1] = (DP[i - 1][2] + DP[i - 1][3]) % MOD;
            DP[i][2] = (DP[i - 2][1] + DP[i - 2][3]) % MOD;
            DP[i][3] = (DP[i - 3][1] + DP[i - 3][2]) % MOD;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println((DP[N][1] + DP[N][2] + DP[N][3]) % MOD);
        }
    }
}