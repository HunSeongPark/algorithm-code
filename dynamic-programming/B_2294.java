import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6:17
public class B_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] DP = new int[k + 1];
        Arrays.fill(DP, 10001);
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coin[j] < 0 || DP[i - coin[j]] == Integer.MAX_VALUE) continue;
                DP[i] = Math.min(DP[i], DP[i - coin[j]] + 1);
            }
        }
        System.out.println(DP[k] == Integer.MAX_VALUE ? -1 : DP[k]);
    }
}