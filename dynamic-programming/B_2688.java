import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] DP = new long[65][10];
        for (int i = 0; i <= 9; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    DP[i][j] += DP[i - 1][k];
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            for (int i = 0; i <= 9; i++) {
                answer += DP[N][i];
            }
            System.out.println(answer);
        }
    }
}