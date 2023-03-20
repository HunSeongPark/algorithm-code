import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] DP = new long[N + 1];
        DP[1] = 3;
        if (N > 1) DP[2] = 7;
        for (int i = 3; i <= N; i++) {
            DP[i] = DP[i - 2] * 3 + (DP[i - 1] - DP[i - 2]) * 2;
            DP[i] %= 9901;
        }
        System.out.println(DP[N]);
    }
}