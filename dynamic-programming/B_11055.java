import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] DP = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = arr[0];
        for (int i = 1; i < N; i++) {
            DP[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) DP[i] = Math.max(DP[i], DP[j] + arr[i]);
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, DP[i]);
        }
        System.out.println(answer);
    }
}
