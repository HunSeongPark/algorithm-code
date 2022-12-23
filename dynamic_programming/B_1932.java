import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1932 {

    static int n;
    static ArrayList<Integer>[] A;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        A = new ArrayList[n];
        DP = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int n = Integer.parseInt(st.nextToken());
                A[i].add(n);
            }
        }
        int max = 0;
        DP[0][0] = A[0].get(0);
        for (int i = 0; i < n; i++) {
            int sum = dp(n - 1, i);
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    private static int dp(int n, int idx) {
        if (DP[n][idx] == -1) {
            if (idx == 0) {
                DP[n][idx] = dp(n - 1, idx) + A[n].get(idx);
            } else if (n == idx) {
                DP[n][idx] = dp(n - 1, idx - 1) + A[n].get(idx);
            } else {
                DP[n][idx] = Math.max(dp(n - 1, idx - 1), dp(n - 1, idx)) + A[n].get(idx);
            }
        }
        return DP[n][idx];
    }
}
