import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_5463 {

    static int N, M;
    static int[][] map, sum;
    static int[][][][] DP;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];
        DP = new int[N + 1][M + 1][N + 1][M + 1];
        fillDP();
        inputMap(br);
        calcPrefixSum();
        System.out.println(dfs(1, 1, N, M));
    }

    public static int dfs(int x, int y, int nx, int ny) {
        if (x == nx && y == ny) return 0;
        if (DP[x][y][nx][ny] != -1) return DP[x][y][nx][ny];
        DP[x][y][nx][ny] = Integer.MAX_VALUE;
        int curSum = sum[nx][ny] - sum[x - 1][ny] - sum[nx][y - 1] + sum[x - 1][y - 1];
        for (int i = x; i < nx; i++) {
            int result1 = dfs(x, y, i, ny);
            int result2 = dfs(i + 1, y, nx, ny);
            DP[x][y][nx][ny] = Math.min(DP[x][y][nx][ny], result1 + result2 + curSum);
        }
        for (int j = y; j < ny; j++) {
            int result1 = dfs(x, y, nx, j);
            int result2 = dfs(x, j + 1, nx, ny);
            DP[x][y][nx][ny] = Math.min(DP[x][y][nx][ny], result1 + result2 + curSum);
        }
        return DP[x][y][nx][ny];
    }

    public static void fillDP() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int ni = 1; ni <= N; ni++) {
                    Arrays.fill(DP[i][j][ni], -1);
                }
            }
        }
    }

    private static void calcPrefixSum() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
            }
        }
    }

    private static void inputMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
