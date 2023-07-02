import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4811 {

    static long[][] DP = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp(30, 0);
        StringBuilder answer = new StringBuilder();
        while (true) {
            int w = Integer.parseInt(br.readLine());
            if (w == 0) break;
            answer.append(DP[w][0]).append("\n");
        }
        System.out.println(answer);
    }

    public static long dp(int w, int h) {
        if (w == 0 && h == 0) return 1;
        if (DP[w][h] != 0) return DP[w][h];
        long ret = 0;
        if (w > 0) {
            ret += dp(w - 1, h + 1);
        }
        if (h > 0) {
            ret += dp(w, h - 1);
        }
        return DP[w][h] = ret;
    }
}
