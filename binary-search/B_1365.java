import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1365 {

    static int N;
    static int[] arr, DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        DP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = arr[0];
        int LIS = 1;
        for (int i = 1; i < N; i++) {
            int idx = binarySearch(arr[i], 0, LIS);
            if (idx == -1) {
                DP[LIS++] = arr[i];
            } else {
                DP[idx] = arr[i];
            }
        }
        System.out.println(N - LIS);
    }

    public static int binarySearch(int target, int S, int E) {
        int ret = -1;
        while (S <= E) {
            int M = (S + E) / 2;
            if (target <= DP[M]) {
                ret = M;
                E = M - 1;
            } else {
                S = M + 1;
            }
        }
        return ret;
    }
}
