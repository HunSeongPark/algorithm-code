import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1654 {

    static int K;
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        long start = 0;
        long end = Integer.MAX_VALUE;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (param_search(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean param_search(long length) {
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += A[i] / length;
        }
        return sum >= N;
    }
}