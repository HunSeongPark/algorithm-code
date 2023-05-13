import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] DP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 1;
        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, DP[i]);
        }
        System.out.println(N - answer);
    }
}