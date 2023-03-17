import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2225 {

    public static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] DP = new long[K + 1][N + 1];
        Arrays.fill(DP[1], 1);
        for (int i = 1; i <= K; i++) {
            DP[i][0] = 1;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
                DP[i][j] %= MOD;
            }
        }
        System.out.println(DP[K][N]);
    }
}