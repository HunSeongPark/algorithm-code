import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1010 {

    public static void main(String[] args) throws IOException {
        int T, N, M;
        int[][] DP;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            DP = new int[M + 1][M + 1];
            for (int i = 0; i <= M; i++) {
                DP[i][i] = 1;
                DP[i][0] = 1;
                DP[i][1] = i;
            }
            for (int i = 2; i <= M; i++) {
                for (int j = 2; j <= N; j++) {
                    DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
                }
            }
            System.out.println(DP[M][N]);
        }
    }
}
