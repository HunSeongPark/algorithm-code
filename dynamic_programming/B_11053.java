import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11053 {

    static int N;
    static int[] A;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        DP = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            if (DP[i] > max) {
                max = DP[i];
            }
        }
        System.out.println(max);
    }
}
