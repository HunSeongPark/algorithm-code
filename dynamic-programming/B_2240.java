import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // T초 / W번 / 현재 위치
        int[][][] DP = new int[1001][31][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DP[1][0][1] = arr[1] == 1 ? 1 : 0;
        DP[1][1][2] = arr[1] == 2 ? 1 : 0;
        for (int t = 2; t <= T; t++) {
            int a1 = arr[t] == 1 ? 1 : 0;
            int a2 = arr[t] == 2 ? 1 : 0;
            DP[t][0][1] = DP[t - 1][0][1] + a1;
            DP[t][0][2] = DP[t - 1][0][2] + a2;
            for (int w = 1; w <= W; w++) {
                DP[t][w][1] = Math.max(DP[t - 1][w][1], DP[t - 1][w - 1][2]) + a1;
                DP[t][w][2] = Math.max(DP[t - 1][w][2], DP[t - 1][w - 1][1]) + a2;
            }
        }
        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, Math.max(DP[T][w][1], DP[T][w][2]));
        }
        System.out.println(answer);
    }
}
