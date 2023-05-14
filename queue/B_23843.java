import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_23843 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> charge = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            if (pq.isEmpty()) break;
            charge.add(pq.poll());
        }
        int time = 0;
        while (!charge.isEmpty()) {
            time = charge.poll();
            while (!charge.isEmpty() && charge.peek() <= time) {
                charge.poll();
            }
            while (!pq.isEmpty() && charge.size() < M) {
                charge.add(time + pq.poll());
            }
        }
        System.out.println(time);
    }
}
