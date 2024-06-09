import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1446 {

    static int N, D;
    static Root[] roots;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        roots = new Root[N];
        dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            roots[i] = new Root(start, end, distance);
        }
        Arrays.sort(roots);
        for (int i = 0; i < N; i++) {
            int start = roots[i].start;
            int end = roots[i].end;
            int distance = roots[i].distance;
            if (end > D) continue;
            if (dp[end] > dp[start] + distance) {
                dp[end] = dp[start] + distance;
                for (int j = end + 1; j <= D; j++) {
                    dp[j] = Math.min(dp[j], dp[end] + j - end);
                }
            }
            dp[end] = Math.min(dp[end], dp[start] + distance);
        }
        System.out.println(dp[D]);
    }

    static class Root implements Comparable<Root> {

        private int start;
        private int end;
        private int distance;

        public Root(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Root o) {
            return this.start - o.start;
        }
    }
}