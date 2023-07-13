import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17779 {

    static int[][] map;
    static int[] sum = new int[6];
    static boolean[][] bound;
    static int N, total = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 > N) continue;
                        if (y - d1 < 1) continue;
                        if (y + d2 > N) continue;
                        check(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void check(int x, int y, int d1, int d2) {
        sum = new int[6];
        bound = new boolean[N + 1][N + 1];

        // bound
        for (int i = 0; i <= d1; i++) {
            bound[x + i][y - i] = true;
            bound[x + i + d2][y - i + d2] = true;
        }
        for (int j = 0; j <= d2; j++) {
            bound[x + j][y + j] = true;
            bound[x + j + d1][y + j - d1] = true;
        }

        // mark number - 1
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (bound[i][j]) break;
                sum[1] += map[i][j];
            }
        }
        // mark number - 2
        for (int i = 1; i <= x + d2; i++) {
            for (int j = N; j > y; j--) {
                if (bound[i][j]) break;
                sum[2] += map[i][j];
            }
        }
        // mark number - 3
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (bound[i][j]) break;
                sum[3] += map[i][j];
            }
        }
        // mark number - 4
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = N; j >= y - d1 + d2; j--) {
                if (bound[i][j]) break;
                sum[4] += map[i][j];
            }
        }
        // 5
        int max = 0;
        int min = Integer.MAX_VALUE;
        int s = 0;
        sum[5] = total;
        for (int i = 1; i <= 4; i++) {
            sum[5] -= sum[i];
        }
        Arrays.sort(sum);
        answer = Math.min(answer, sum[5] - sum[1]);
    }
}
