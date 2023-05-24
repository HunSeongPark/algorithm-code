import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17090 {

    static final int R = 0;
    static final int D = 1;
    static final int U = 2;
    static final int L = 3;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] map;
    static int[][] check;
    static boolean[][] visited;
    static int N, M, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        check = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = s.charAt(j - 1);
                map[i][j] = c == 'R' ? R : c == 'D' ? D : c == 'U' ? U : L;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (check[i][j] == 1) answer++;
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int i, int j) {
        if (i <= 0 || i > N || j <= 0 || j > M) {
            return 1;
        }
        if (check[i][j] != 0) {
            return check[i][j];
        }
        if (visited[i][j]) {
            check[i][j] = -1;
            return -1;
        }
        visited[i][j] = true;
        int x = i + dx[map[i][j]];
        int y = j + dy[map[i][j]];
        check[i][j] = dfs(x, y);
        return check[i][j];
    }
}