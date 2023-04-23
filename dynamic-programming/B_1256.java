import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1256
{

    public static long[][] DP;
    public static int N, M, K;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        DP = new long[101][101];
        countDP();
        if (DP[N][M] < K) {
            System.out.println(-1);
        } else {
            find();
            System.out.println(answer);
        }
    }

    public static void countDP() {
        for (int i = 1; i <= 100; i++) {
            DP[i][0] = DP[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                DP[i][j] = Math.min(DP[i - 1][j] + DP[i][j - 1], 1000000001);
            }
        }
    }

    public static void find() {
        int a = N;
        int z = M;
        for (int i = 0; i < N + M; i++) {
            if (a == 0) {
                while (z > 0) {
                    answer.append("z");
                    z--;
                }
                break;
            }
            if (z == 0) {
                while (a > 0) {
                    answer.append("a");
                    a--;
                }
                break;
            }
            long cur = DP[a - 1][z];
            if (K <= cur) {
                answer.append("a");
                a--;
            } else {
                K -= cur;
                answer.append("z");
                z--;
            }
        }
    }
}