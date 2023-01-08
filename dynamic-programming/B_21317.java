import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[23][2];
        int[][] DP = new int[23][2];
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= 22; i++) {
            Arrays.fill(DP[i], Integer.MAX_VALUE);
        }
        int k = Integer.parseInt(br.readLine());
        DP[1][0] = 0;
        DP[1][1] = 0;
        for (int i = 1; i < N; i++) {
            DP[i + 1][0] = Math.min(DP[i + 1][0], DP[i][0] + A[i][0]);
            DP[i + 1][1] = Math.min(DP[i + 1][1], DP[i][1] + A[i][0]);
            DP[i + 2][0] = Math.min(DP[i + 2][0], DP[i][0] + A[i][1]);
            DP[i + 2][1] = Math.min(DP[i + 2][1], DP[i][1] + A[i][1]);
            DP[i + 3][1] = Math.min(DP[i + 3][1], DP[i][0] + k);
        }
        System.out.println(Math.min(DP[N][0], DP[N][1]));
    }
}