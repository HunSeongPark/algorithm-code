import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16724 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int N, M;
    static int[][] visited;
    static int visitedIdx = 1;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c == 'L' ? 0 : c == 'R' ? 1 : c == 'D' ? 2 : 3;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    answer++;
                    dfs(i, j);
                    visitedIdx++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int i, int j) {
        if (visited[i][j] == visitedIdx) return;
        if (visited[i][j] != 0) {
            answer--;
            return;
        }
        visited[i][j] = visitedIdx;
        dfs(i + dx[map[i][j]], j + dy[map[i][j]]);
    }
}
