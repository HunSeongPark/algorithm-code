import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_15988
{

    static final int MOD = 1_000_000_009;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] DP = new long[1_000_001];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % MOD;
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            System.out.println(DP[Integer.parseInt(br.readLine())]);
        }
    }

}