import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14855 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] C = new int[m + 1];
        int[] D = new int[m + 1];
        int[] count = new int[m + 1];
        int[][] DP = new int[10001][n + 1];
        C[0] = Integer.parseInt(st.nextToken());
        D[0] = Integer.parseInt(st.nextToken());
        count[0] = n / C[0];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
            count[i] = Math.min(n / C[i], a / b);
        }
        int idx = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < count[i]; j++) {
                for (int k = n; k > 0; k--) {
                    if (k - C[i] >= 0) {
                        DP[idx][k] = Math.max(DP[idx - 1][k], DP[idx - 1][k - C[i]] + D[i]);
                    } else {
                        DP[idx][k] = DP[idx - 1][k];
                    }
                }
                idx++;
            }
        }
        System.out.println(DP[idx - 1][n]);
    }
}