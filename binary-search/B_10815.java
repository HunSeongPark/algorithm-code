import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10815 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            answer.append(binarySearch(n)).append(" ");
        }
        System.out.println(answer);
    }

    public static int binarySearch(int n) {
        int L = 0;
        int R = N - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (arr[M] == n) {
                return 1;
            } else if (arr[M] < n) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return 0;
    }
}