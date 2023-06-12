import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17069 {

    static final int TOP = 0;
    static final int CROSS = 1;
    static final int LEFT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[][][] DP = new long[N][N][3];
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < N; j++) {
            if (map[0][j] == 1) break;
            DP[0][j][LEFT] = 1;
        }
        DP[0][0][LEFT] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) continue;
                // TOP (대각선, 세로)
                DP[i][j][TOP] = DP[i - 1][j][CROSS] + DP[i - 1][j][TOP];

                // CROSS (가로, 세로, 대각선)
                if (j > 0 && map[i][j - 1] == 0 && map[i - 1][j] == 0) {
                    DP[i][j][CROSS] = DP[i - 1][j - 1][TOP] + DP[i - 1][j - 1][CROSS] + DP[i - 1][j - 1][LEFT];
                }
                // LEFT (대각선, 가로)
                if (j > 0) {
                    DP[i][j][LEFT] = DP[i][j - 1][CROSS] + DP[i][j - 1][LEFT];
                }
            }
        }
        System.out.println(DP[N - 1][N - 1][LEFT] + DP[N - 1][N - 1][TOP] + DP[N - 1][N - 1][CROSS]);
    }
}