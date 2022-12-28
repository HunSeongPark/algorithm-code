import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(A);
        long max_num = A[0];
        int max = 1;
        int cur_cnt = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] == A[i - 1]) {
                cur_cnt++;
            } else {
                cur_cnt = 1;
            }
            if (max < cur_cnt) {
                max = cur_cnt;
                max_num = A[i];
            }
        }
        System.out.println(max_num);
    }
}
