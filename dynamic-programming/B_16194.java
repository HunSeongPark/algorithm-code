import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];
        int[] cards = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            DP[i] = Integer.parseInt(st.nextToken());
            cards[i] = DP[i];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.min(DP[i], DP[i - j] + cards[j]);
            }
        }
        System.out.println(DP[N]);
    }
}