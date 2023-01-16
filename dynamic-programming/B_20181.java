import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_20181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] DP = new long[N + 1];
        ArrayList<Interval>[] intervals = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            intervals[i] = new ArrayList<>();
        }
        long sum = 0;
        for (int start = 1, end = 0; start <= N; start++) {
            while (sum < K && end + 1 <= N) {
                sum += A[++end];
            }
            if (sum >= K) {
                Interval interval = new Interval(start, sum - K);
                intervals[end].add(interval);
            }
            sum -= A[start];
        }
        for (int i = 1; i <= N; i++) {
            DP[i] = DP[i - 1];
            for (Interval interval : intervals[i]) {
                DP[i] = Math.max(DP[i], DP[interval.left - 1] + interval.result);
            }
        }
        System.out.println(DP[N]);
    }

    public static class Interval {
        int left;
        long result;

        public Interval(int left, long result) {
            this.left = left;
            this.result = result;
        }
    }
}