import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] DP = new int[11];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for (int i = 4; i <= 10; i++) {
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
        }
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(DP[n]);
        }
    }
}