import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14698
{
    public static void main(String args[]) throws Exception {
        final long MOD = 1_000_000_007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            long answer = 1;
            while (queue.size() > 1) {
                long mul = queue.poll();
                queue.add(mul);
                answer *= mul % MOD;
                answer %= MOD;
                queue.add(mul);
            }
            sb.append(answer + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}