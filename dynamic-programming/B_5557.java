import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5557 {

    static long[][] DP;
    static int[] num;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new long[N][21];
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        DP[0][num[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (DP[i - 1][j] != 0) {
                    int p = j + num[i];
                    int m = j - num[i];
                    if (p <= 20) {
                        DP[i][p] += DP[i - 1][j];
                    }
                    if (m >= 0) {
                        DP[i][m] += DP[i - 1][j];
                    }
                }
            }
        }
        System.out.println(DP[N - 2][num[N - 1]]);
    }
}