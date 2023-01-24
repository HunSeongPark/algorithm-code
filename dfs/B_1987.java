import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1987 {

    static int R, C;
    static boolean[] visited = new boolean[26];
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int i, int j, int sum) {
        if (visited[map[i][j]]) {
            max = Math.max(max, sum);
            return;
        }
        visited[map[i][j]] = true;
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x >= 0 && x < R && y >= 0 && y < C) {
                dfs(x, y, sum + 1);
            }
        }
        visited[map[i][j]] = false;
    }
}