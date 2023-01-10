import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        int[][] DP = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(A[1]);
            return;
        }
        DP[1][0] = 0;
        DP[1][1] = A[1];
        DP[2][0] = A[1];
        DP[2][1] = A[1] + A[2];

        for (int i = 3; i <= n; i++) {
            DP[i][0] = DP[i - 1][1];
            DP[i][1] = Math.max(DP[i - 1][0], Math.max(DP[i - 2][0] + A[i - 1], DP[i - 3][0] + A[i - 1])) + A[i];
        }
        System.out.println(Math.max(DP[n][0], DP[n][1]));
    }
}