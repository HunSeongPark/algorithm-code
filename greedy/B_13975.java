import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            long answer = 0;
            while (queue.size() > 1) {
                long n = queue.poll() + queue.poll();
                answer += n;
                queue.add(n);
            }
            System.out.println(answer);
        }
    }
}