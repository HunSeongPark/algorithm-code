import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger[] DP = new BigInteger[N + 1];
        DP[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1].multiply(BigInteger.valueOf(i));
        }
        System.out.println(DP[N].divide(DP[N - M].multiply(DP[M])));
    }
}
