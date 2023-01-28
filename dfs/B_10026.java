import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10026 {

    static int N;
    static char[][] map;
    static boolean[][] visited_a;
    static boolean[][] visited_b;
    static int result1 = 0;
    static int result2 = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited_a = new boolean[N][N];
        visited_b = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited_a[i][j]) {
                    result1++;
                    visited_a[i][j] = true;
                    dfs_a(i, j);
                }
                if (!visited_b[i][j]) {
                    result2++;
                    visited_b[i][j] = true;
                    dfs_b(i, j);
                }
            }
        }
        System.out.println(result1 + " " + result2);
    }

    public static void dfs_a(int i, int j) {
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x >= 0 && x < N && y >= 0 && y < N && !visited_a[x][y] && map[x][y] == map[i][j]) {
                visited_a[x][y] = true;
                dfs_a(x, y);
            }
        }
    }

    public static void dfs_b(int i, int j) {
        for (int n = 0; n < 4; n++) {
            int x = i + dx[n];
            int y = j + dy[n];

            if (x >= 0 && x < N && y >= 0 && y < N && !visited_b[x][y]) {
                if ((map[i][j] == 'B' && map[x][y] == 'B') ||
                        (map[i][j] == 'R' && map[x][y] == 'R') ||
                        (map[i][j] == 'R' && map[x][y] == 'G') ||
                        (map[i][j] == 'G' && map[x][y] == 'R') ||
                        (map[i][j] == 'G' && map[x][y] == 'G')) {
                    visited_b[x][y] = true;
                    dfs_b(x, y);
                }
            }
        }
    }
}