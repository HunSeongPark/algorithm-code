import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2775 {

    public static void main(String[] args) throws IOException {
        int T, k, n;
        int[][] DP;
        DP = new int[15][15];
        for (int i = 0; i <= 14; i++) {
            DP[i][1] = 1;
            DP[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            System.out.println(DP[k][n]);
        }
    }

}
