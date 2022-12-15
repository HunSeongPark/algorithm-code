import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012 {

    static int M;
    static int N;
    static int[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        int T;
        int K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new int[M][N];
            int result = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                visited[x][y] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int x, int y) {
        if (visited[x][y] == 0) {
            return;
        }
        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if (new_x >= 0 && new_y >= 0 && new_x < M && new_y < N) {
                dfs(new_x, new_y);
            }
        }
    }
}