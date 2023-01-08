import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int n = 0; n <= 9; n++) {
                for (int j = 0; j <= n; j++) {
                    DP[i][n] += DP[i - 1][j];
                    DP[i][n] %= 10007;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += DP[N][i];
            result %= 10007;
        }
        System.out.println(result);
    }
}