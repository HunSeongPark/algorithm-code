import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];
        DP[1] = -1;
        DP[2] = -1;
        DP[3] = 1;
        if (N == 4) {
            DP[4] = -1;
        }
        if (N >= 5) {
            DP[5] = 1;
        }
        for (int i = 6; i <= N; i++) {
            if (i % 5 == 0) {
                DP[i] = DP[i - 5] + 1;
            } else if (i % 3 == 0) {
                DP[i] = DP[i - 3] + 1;
            } else if (DP[i - 3] != -1 && DP[i - 5] != -1) {
                DP[i] = Math.min(DP[i - 3], DP[i - 5]) + 1;
            } else {
                DP[i] = -1;
            }
        }
        System.out.println(DP[N]);
    }
}
