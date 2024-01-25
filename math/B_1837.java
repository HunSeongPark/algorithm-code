import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_1837 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[K + 1];
        getPrime(K, primes);
        for (int k = 2; k < K; k++) {
            if (primes[k]) continue;
            BigInteger n = new BigInteger(Integer.toString(k));
            if (P.mod(n).equals(BigInteger.ZERO)) {
                System.out.println("BAD " + k);
                return;
            }
        }
        System.out.println("GOOD");
    }

    private static void getPrime(int K, boolean[] primes) {
        for (int i = 2; i * i <= K; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= K; j+=i) {
                    primes[j] = true;
                }
            }
        }
    }
}
