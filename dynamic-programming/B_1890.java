import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] DP = new long[N + 1][N + 1];
        DP[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int num = A[i][j];
                if (num == 0) {
                    continue;
                }
                if (i + num <= N) {
                    DP[i + num][j] += DP[i][j];
                }
                if (j + num <= N) {
                    DP[i][j + num] += DP[i][j];
                }
            }
        }
        System.out.println(DP[N][N]);
    }
}