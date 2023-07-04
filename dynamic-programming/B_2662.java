import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7 15
public class B_2662 {

    static int[] path;
    static int[][] invest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] DP = new int[N + 1][M + 1];
        int[][] benefit = new int[N + 1][M + 1];
        invest = new int[N + 1][M + 1];
        path = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 1; j <= M; j++) {
                benefit[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j <= M; j++) {
            for (int i = 0; i <= N; i++) {
                for (int k = N - i; k >= 0; k--) {
                    if (DP[k][j - 1] + benefit[i][j] > DP[k + i][j]) {
                        DP[k + i][j] = DP[k][j - 1] + benefit[i][j];
                        invest[k + i][j] = i;
                    }
                }
            }
        }

        findPath(N, M);
        StringBuilder answer = new StringBuilder();
        answer.append(DP[N][M]).append("\n");
        for (int i = 1; i <= M; i++) {
            answer.append(path[i]).append(" ");
        }
        System.out.println(answer);
    }

    public static void findPath(int n, int m) {
        if (m == 0) return;
        path[m] = invest[n][m];
        findPath(n - path[m], m - 1);
    }
}