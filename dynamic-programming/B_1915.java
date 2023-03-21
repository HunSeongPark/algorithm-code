import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = s.charAt(j) - '0';
            }
        }
        int[][] DP = new int[N + 1][M + 1];
        DP[1][1] = map[1][1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    DP[i][j] = Math.min(DP[i - 1][j], Math.min(DP[i][j - 1], DP[i - 1][j - 1])) + 1;
                    answer = Math.max(answer, DP[i][j]);
                }
            }
        }
        System.out.println(answer * answer);
    }
}