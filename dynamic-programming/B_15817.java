import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] DP = new int[10001];
        DP[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            for (int x = X; x > 0; x--) {
                int curL = 0;
                for (int c = 0; c < C; c++) {
                    curL += L;
                    if (x - curL < 0) break;
                    DP[x] += DP[x - curL];
                }
            }
        }
        System.out.println(DP[X]);
    }
}