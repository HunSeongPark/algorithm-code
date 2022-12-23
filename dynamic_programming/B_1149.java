import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static int[][] cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        DP = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            cost[i][RED] = red;
            cost[i][GREEN] = green;
            cost[i][BLUE] = blue;
        }
        DP[0][RED] = cost[0][RED];
        DP[0][GREEN] = cost[0][GREEN];
        DP[0][BLUE] = cost[0][BLUE];
        System.out.println(Math.min(dp(N - 1, RED), Math.min(dp(N - 1, GREEN), dp(N - 1, BLUE))));
    }

    public static int dp(int n, int c) {
        if (DP[n][c] == 0) {
            if (c == RED) {
                DP[n][c] = Math.min(dp(n - 1, GREEN), dp(n - 1, BLUE)) + cost[n][c];
            } else if (c == GREEN) {
                DP[n][c] = Math.min(dp(n - 1, RED), dp(n - 1, BLUE)) + cost[n][c];
            } else {
                DP[n][c] = Math.min(dp(n - 1, RED), dp(n - 1, GREEN)) + cost[n][c];
            }
        }
        return DP[n][c];
    }
}
