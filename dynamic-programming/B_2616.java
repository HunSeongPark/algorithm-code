import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        int M = Integer.parseInt(br.readLine());
        int[][] DP = new int[N + 1][4];
        for (int i = 1; i <= M; i++) {
            DP[M][1] += arr[i];
        }
        for (int i = M + 1; i <= N; i++) {
            int curSum = sum[i] - sum[i - M];
            for (int j = 1; j <= 3; j++) {
                DP[i][j] = Math.max(DP[i - 1][j], DP[i - M][j - 1] + curSum);
            }
        }
        System.out.println(DP[N][3]);
    }
}