import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2110 {

    static int N;
    static int C;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int start = 1;
        int end = 1_000_000_000;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (param_search(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean param_search(int distance) {
        boolean isPossible = false;
        int last = 0;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] - A[last] >= distance) {
                count++;
                last = i;
            }
            if (count == C) {
                isPossible = true;
                break;
            }
        }
        return isPossible;
    }
}