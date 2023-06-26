import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_16400 {

    static int N;
    static ArrayList<Integer> primes = new ArrayList<>();
    static final int MOD = 123_456_789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        getPrimes();
        long[] DP = new long[N + 1];
        DP[0] = 1;
        for (int prime : primes) {
            for (int i = prime; i <= N; i++) {
                DP[i] = (DP[i] + DP[i - prime]) % MOD;
            }
        }
        System.out.println(DP[N]);
    }

    public static void getPrimes() {
        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) primes.add(i);
        }
    }
}