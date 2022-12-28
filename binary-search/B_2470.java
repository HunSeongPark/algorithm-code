import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
        }
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < N; i++) {
            int idx = binary_search(A, i + 1, N - 1, -A[i]);
            if (idx >= i + 1 && idx < N && Math.abs(A[i] + A[idx]) < min) {
                min = Math.abs(A[i] + A[idx]);
                n1 = A[i];
                n2 = A[idx];
            }
            if (idx - 1 >= i + 1 && idx - 1 < N && Math.abs(A[i] + A[idx - 1]) < min) {
                min = Math.abs(A[i] + A[idx - 1]);
                n1 = A[i];
                n2 = A[idx - 1];
            }
        }
        System.out.println(n1 + " " + n2);
    }

    private static int binary_search(int[] A, int start, int end, int target) {
        int result = end + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}