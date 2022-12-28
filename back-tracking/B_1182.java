import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1182 {

    static int N, S;
    static int[] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (S == 0) {
            result--;
        }
        System.out.println(result);
    }

    private static void dfs(int idx, int value) {
        if (idx >= N) {
            if (value == S) {
                result++;
            }
        } else {
            dfs(idx + 1, value + A[idx]);
            dfs(idx + 1, value);
        }
    }
}
