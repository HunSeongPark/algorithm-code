import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        int[] DP = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        DP[1] = A[1];
        if (n > 1) {
            DP[2] = A[1] + A[2];
        }
        for (int i = 3; i <= n; i++) {
            DP[i] = Math.max(DP[i - 2], DP[i - 3] + A[i - 1]) + A[i];
        }
        System.out.println(DP[n]);
    }
}
