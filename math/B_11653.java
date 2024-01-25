import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                answer.append(i).append("\n");
                N /= i;
            }
        }
        if (N != 1) answer.append(N).append("\n");
        System.out.println(answer);
    }
}
