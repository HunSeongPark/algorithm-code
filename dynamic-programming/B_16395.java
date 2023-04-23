import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16395 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] DP = new int[N + 1][K + 1];
        DP[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
            }
        }
        System.out.println(DP[N][K]);
    }
}