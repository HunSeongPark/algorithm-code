import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2502 {

    static final int A = 0;
    static final int B = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] DP = new int[D + 1][2];
        DP[1][A] = DP[2][B] = 1;
        for (int i = 3; i <= D; i++) {
            DP[i][A] = DP[i - 2][A] + DP[i - 2][B];
            DP[i][B] = DP[i - 1][A] + DP[i - 1][B];
        }
        int a = 1;
        int b = 0;
        while (true) {
            b = K - DP[D][A] * a;
            if (b % DP[D][B] == 0) {
                b /= DP[D][B];
                if (b >= a) break;
            }
            a++;
        }
        System.out.println(a);
        System.out.println(b);
    }
}