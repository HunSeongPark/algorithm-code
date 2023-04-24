import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15684
{
    static int[][] map;
    static int N, M, H;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
        for (int count = 0; count <= 3; count++) {
            if (dfs(1, 0, 0, count)) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }

    public static boolean dfs(int x, int y, int depth, int count) {
        if (depth == count) {
            return check();
        }
        for (int i = x; i <= H; i++) {
            for (int j = i == x ? y + 1 : 1; j < N; j++) {
                if (map[i][j] == 0) {
                    if (map[i][j - 1] == 1 || map[i][j + 1] == 1) continue;
                    map[i][j] = 1;
                    if (dfs(i, j, depth + 1, count)) return true;
                    map[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static boolean check() {
        for (int j = 1; j <= N; j++) {
            int cur = j;
            for (int i = 1; i <= H; i++) {
                if (map[i][cur] == 1) {
                    cur++;
                } else if (cur - 1 >= 0 && map[i][cur - 1] == 1) {
                    cur--;
                }
            }
            if (j != cur) return false;
        }
        return true;
    }
}