import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11051 {

    public static void main(String[] args) throws IOException {
        int N, K;
        int[][] DP;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        DP = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            DP[i][1] = i;
            DP[i][0] = 1;
            DP[i][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j < i; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
                DP[i][j] %= 10007;
            }
        }
        System.out.println(DP[N][K]);
    }

}
