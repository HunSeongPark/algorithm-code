import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] DP = new int[K + 1][2];
        DP[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            DP[i][0] = DP[i - 1][1];
            DP[i][1] = DP[i - 1][0] + DP[i - 1][1];
        }
        System.out.println(DP[K][0] + " " + DP[K][1]);
    }
}