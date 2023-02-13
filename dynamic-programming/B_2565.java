import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] wire = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] DP = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wire[j][1] < wire[i][1]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            max = Math.max(max, DP[i]);
        }
        System.out.println(N - max);
    }
}