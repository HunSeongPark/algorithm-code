import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] novel = new int[K + 1];
            int[][] DP = new int[K + 1][K + 1];
            int[] sum = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + novel[i];
            }
            // n장씩 묶기
            for (int n = 1; n <= K; n++) {
                for (int i = 1; i + n <= K; i++) {
                    int j = i + n;
                    DP[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }
            System.out.println(DP[1][K]);
        }
    }
}
