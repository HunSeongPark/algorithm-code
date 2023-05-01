import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        M = Integer.parseInt(br.readLine());
        if (sum <= M) {
            System.out.println(max);
            return;
        }
        int L = 0;
        int R = M;
        int answer = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (check(mid, M)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int mid, int m) {
        for (int i : arr) {
            m -= Math.min(i, mid);
        }
        return m >= 0;
    }
}