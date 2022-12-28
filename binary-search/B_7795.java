import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            int result = 0;
            for (int i = 0; i < N; i++) {
                int num = A[i];
                int sum = 0;
                int start = 0;
                int end = B.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (B[mid] < num) {
                        sum = mid + 1;
                        start = mid + 1;
                    } else if (B[mid] >= num) {
                        end = mid - 1;
                    }
                }
                result += sum;
            }
            System.out.println(result);
        }
    }
}