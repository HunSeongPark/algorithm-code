import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_10816 {

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(upper(n) - lower(n)).append(" ");
        }
        System.out.println(sb);
    }

    public static int lower(int key) {
        int L = 0;
        int R = A.length;
        while (L < R) {
            int mid = (L + R) / 2;

            if (key <= A[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public static int upper(int key) {
        int L = 0;
        int R = A.length;
        while (L < R) {
            int mid = (L + R) / 2;

            if (key < A[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}