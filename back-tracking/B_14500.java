import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14500 {

    static int N, M, answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int i, int j, int result, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, result);
            return;
        }
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x < 0 || x >= N || y < 0 || y >= M) continue;
            if (!visited[x][y]) {
                if (depth == 2) {
                    visited[x][y] = true;
                    dfs(i, j, result + map[x][y], depth + 1);
                    visited[x][y] = false;
                }
                visited[x][y] = true;
                dfs(x, y, result + map[x][y], depth + 1);
                visited[x][y] = false;
            }
        }
    }
}