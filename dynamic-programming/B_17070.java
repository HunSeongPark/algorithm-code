import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17070 {

    static final int TOP = 0;
    static final int LEFT = 1;
    static final int CROSS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N + 1][N + 1];
        int[][][] DP = new int[N + 1][N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n == 0;
            }
        }
        for (int j = 1; j <= N; j++) {
            if (!map[1][j]) break;
            DP[1][j][LEFT] = 1;
        }
        DP[1][1][LEFT] = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!map[i][j]) continue;
                // CROSS
                if (map[i - 1][j] && map[i][j - 1]) {
                    DP[i][j][CROSS] += DP[i - 1][j - 1][LEFT] + DP[i - 1][j - 1][CROSS] + DP[i - 1][j - 1][TOP];
                }

                // TOP
                DP[i][j][LEFT] += DP[i][j - 1][LEFT] + DP[i][j - 1][CROSS];

                // LEFT
                DP[i][j][TOP] += DP[i - 1][j][TOP] + DP[i - 1][j][CROSS];
            }
        }
        System.out.println(DP[N][N][CROSS] + DP[N][N][TOP] + DP[N][N][LEFT]);
    }
}
