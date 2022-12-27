import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];
        DP[1] = 1;
        if (N >= 2) {
            DP[2] = 3;
        }
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2] * 2) % 10007;
        }
        System.out.println(DP[N] % 10007);
    }
}
