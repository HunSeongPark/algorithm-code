import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1937 {

    static int N;
    static int[][] map;
    static int[][] DP;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        DP = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(DP[i], -1);
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int i, int j) {
        if (DP[i][j] != -1) {
            return DP[i][j];
        }
        DP[i][j] = 1;
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (map[i][j] < map[x][y]) {
                DP[i][j] = Math.max(DP[i][j], dfs(x, y) + 1);
            }
        }
        return DP[i][j];
    }
}