import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] DP = new long[N + 1][2];
        DP[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
            DP[i][1] = DP[i - 1][0];
        }
        System.out.println(DP[N][0] + DP[N][1]);
    }
}
