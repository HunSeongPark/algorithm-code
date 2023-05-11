import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_7579 {

    static int N, M;
    static int[] m, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] DP = new int[10001];
        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= c[i]; j--) {
                DP[j] = Math.max(DP[j], DP[j - c[i]] + m[i]);
            }
        }
        for (int i = 0; i <= 10000; i++) {
            if (DP[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
