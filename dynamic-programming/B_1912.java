import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] DP = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        DP[1] = A[1];
        int max = A[1];
        for (int i = 2; i <= N; i++) {
            DP[i] = Math.max(DP[i - 1] + A[i], A[i]);
            max = Math.max(max, DP[i]);
        }
        System.out.println(max);
    }
}
