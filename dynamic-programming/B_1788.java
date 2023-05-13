import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1788 {

    static int N;
    static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new long[Math.abs(N) + 1];
        if (N == 0) System.out.println(0);
        else if (N > 0 || N % 2 == -1) System.out.println(1);
        else System.out.println(-1);
        fib(Math.abs(N));
        System.out.println(DP[Math.abs(N)]);
    }

    public static void fib(int N) {
        if (N == 1 || N == 2) {
            DP[N] = 1;
            return;
        }
        if (N == 0) return;
        if (DP[N] != 0) return;
        fib(N - 1);
        fib(N - 2);
        DP[N] = (DP[N - 1] + DP[N - 2]) % 1_000_000_000;
    }
}