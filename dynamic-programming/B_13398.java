import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[][] DP = new int[n][2];
        DP[0][0] = A[0];
        DP[0][1] = A[0];
        int max = A[0];
        for (int i = 1; i < n; i++) {
            DP[i][0] = Math.max(DP[i - 1][0] + A[i], A[i]);
            DP[i][1] = Math.max(DP[i - 1][0], DP[i - 1][1] + A[i]);
            max = Math.max(max, Math.max(DP[i][0], DP[i][1]));
        }
        System.out.println(max);
    }
}
