import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, DP[i - j * j]);
            }
            DP[i] = min + 1;
        }
        System.out.println(DP[N]);
    }
}
