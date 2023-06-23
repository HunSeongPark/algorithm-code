import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        boolean[][] DP = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            DP[i][i] = true;
            if (arr[i - 1] == arr[i]) DP[i - 1][i] = true;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 1; j + i <= N; j++) {
                DP[j][j + i] = arr[j] == arr[j + i] && DP[j + 1][j + i - 1];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            answer.append(DP[S][E] ? 1 : 0).append("\n");
        }
        System.out.println(answer);
    }
}