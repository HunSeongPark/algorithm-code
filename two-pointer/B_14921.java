import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int L = 0;
        int R = N - 1;
        int answer = Integer.MAX_VALUE;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }
            if (sum == 0) {
                break;
            } else if (sum > 0) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(answer);
    }
}
