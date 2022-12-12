import java.io.*;
import java.util.Scanner;

public class B_1463 {

    static int N;
    static Integer[] DP;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dp(N));
        clear();
    }

    private static int dp(int n) {

        if (DP[n] == null) {
            if (n % 6 == 0) {
                DP[n] = Math.min(dp(n / 3), Math.min(dp(n / 2), dp(n - 1))) + 1;
            } else if (n % 3 == 0) {
                DP[n] = Math.min(dp(n / 3), dp(n - 1)) + 1;
            } else if (n % 2 == 0) {
                DP[n] = Math.min(dp(n / 2), dp(n - 1)) + 1;
            } else {
                DP[n] = dp(n - 1) + 1;
            }
        }
        return DP[n];
    }

    private static void input() throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DP = new Integer[N + 1];
        DP[0] = 0;
        DP[1] = 0;
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}