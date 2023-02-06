import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16929 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int start_i;
    static int start_j;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                start_i = i;
                start_j = j;
                if (dfs(i, j, 0)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static boolean dfs(int i, int j, int depth) {
        visited[i][j] = true;
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x < 0 || x >= N || y < 0 || y >= M) continue;
            if (start_i == x && start_j == y && depth + 1 >= 4) {
                return true;
            }
            if (!visited[x][y] && map[start_i][start_j] == map[x][y]) {
                if (dfs(x, y, depth + 1)) return true;
                visited[x][y] = false;
            }
        }
        return false;
    }
}