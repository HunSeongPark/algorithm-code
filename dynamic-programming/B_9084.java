import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coin = new int[N];
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] DP = new int[M + 1];
            DP[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - coin[i] >= 0) {
                        DP[j] += DP[j - coin[i]];
                    }
                }
            }
            System.out.println(DP[M]);
        }
    }
}