import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Hunseong-Park
 * @date : 2022-11-30
 */
public class B_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;
        long[] S = new long[N];
        long[] C = new long[M];
        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int mod = (int) (S[i] % M);
            if (mod == 0) result++;
            C[mod]++;
        }
        for (int i = 0; i < M; i++) {
            result = result + (C[i] * (C[i] - 1) / 2);
        }
        System.out.println(result);
    }
}
