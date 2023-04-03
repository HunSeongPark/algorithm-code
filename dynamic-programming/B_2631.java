import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] DP = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) DP[i] = Math.max(DP[i], DP[j] + 1);
            }
            max = Math.max(max, DP[i]);
        }
        System.out.println(N - max);
    }
}