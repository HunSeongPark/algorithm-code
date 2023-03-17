import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10422 {

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] DP = new long[5001];
        DP[0] = 1;
        DP[2] = 1;
        for (int i = 4; i <= 5000; i+=2) {
            for (int j = 2; j <= i; j+=2) {
                DP[i] += DP[j - 2] * DP[i - j];
                DP[i] %= MOD;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(DP[N]);
        }
    }
}