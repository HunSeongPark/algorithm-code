import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2580 {

    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);
    }

    public static void dfs(int i, int j) {
        if (j > 9) {
            dfs(i + 1, 1);
        } else if (i > 9) {
            StringBuilder sb = new StringBuilder();
            for (int x = 1; x <= 9; x++) {
                for (int y = 1; y <= 9; y++) {
                    sb.append(map[x][y]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        } else if (map[i][j] == 0) {
            for (int n = 1; n <= 9; n++) {
                if (isPossible(i, j, n)) {
                    map[i][j] = n;
                    dfs(i, j + 1);
                }
            }
            map[i][j] = 0;
        } else {
            dfs(i, j + 1);
        }
    }

    public static boolean isPossible(int x, int y, int n) {
        // 가로 확인
        for (int j = 1; j <= 9; j++) {
            if (map[x][j] == n) return false;
        }

        // 세로 확인
        for (int i = 1; i <= 9; i++) {
            if (map[i][y] == n) return false;
        }

        // 정사각형 확인
        int nx = (x - 1) / 3 * 3 + 1;
        int ny = (y - 1) / 3 * 3 + 1;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (map[i][j] == n) return false;
            }
        }
        return true;
    }
}