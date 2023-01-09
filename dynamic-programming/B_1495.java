import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] V = new int[N + 1];
        boolean[][] DP = new boolean[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }
        if (S + V[1] <= M) {
            DP[1][S + V[1]] = true;
        }
        if (S - V[1] >= 0) {
            DP[1][S - V[1]] = true;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!DP[i][j]) continue;
                if (j + V[i + 1] <= M) {
                    DP[i + 1][j + V[i + 1]] = true;
                }
                if (j - V[i + 1] >= 0) {
                    DP[i + 1][j - V[i + 1]] = true;
                }
            }
        }
        int result = -1;
        for (int i = 0; i <= M; i++) {
            if (DP[N][i]) result = i;
        }
        System.out.println(result);
    }
}