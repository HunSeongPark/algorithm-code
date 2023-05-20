import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (pq.isEmpty()) {
                    answer.append(0).append("\n");
                } else {
                    answer.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(n);
            }
        }
        System.out.println(answer);
    }
}