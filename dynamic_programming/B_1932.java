import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1932 {

    static int n;
    static int[][] A;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        A = new int[n][n];
        DP = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(DP[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int n = Integer.parseInt(st.nextToken());
                A[i][j] = n;
            }
        }
        for (int i = 0; i < n; i++) {
            DP[n - 1][i] = A[n - 1][i];
        }
        System.out.println(dp(0, 0));
    }

    private static int dp(int n, int idx) {
        if (DP[n][idx] == -1) {
            DP[n][idx] = A[n][idx] + Math.max(dp(n + 1, idx), dp(n + 1, idx + 1));
        }
        return DP[n][idx];
    }
}
