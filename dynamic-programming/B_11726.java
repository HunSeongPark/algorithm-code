import java.io.*;
import java.util.StringTokenizer;

public class B_11726 {

    static int n;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
        clear();
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}