import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = {-1, 0, 1};
        int[][] score = new int[N][3];
        int[][][] DP = new int[N][3][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                DP[i][j][0] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < 3; j++) {
            DP[0][j][0] = score[0][j];
            DP[0][j][1] = score[0][j];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int n = 0; n < 3; n++) {
                    int y = j + dy[n];
                    if (y < 0 || y >= 3) continue;
                    DP[i][j][0] = Math.min(DP[i][j][0], DP[i - 1][y][0]);
                    DP[i][j][1] = Math.max(DP[i][j][1], DP[i - 1][y][1]);
                }
                DP[i][j][0] += score[i][j];
                DP[i][j][1] += score[i][j];
            }
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            max = Math.max(max, DP[N - 1][j][1]);
            min = Math.min(min, DP[N - 1][j][0]);
        }
        System.out.println(max + " " + min);
    }
}