import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            int[] result = new int[N];
            int left = 0;
            int right = N - 1;
            for (int i = 0; i < N; i+=2) {
                result[left++] = A[i];
                if (i + 1 < N) result[right--] = A[i + 1];
            }
            int max = 0;
            for (int i = 0; i < N - 1; i++) {
                max = Math.max(max, Math.abs(result[i] - result[i + 1]));
            }
            System.out.println(max);
        }
    }
}