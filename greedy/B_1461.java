import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plus = new PriorityQueue<>((n1, n2) -> n2 - n1);
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n < 0) {
                minus.add(n);
            } else {
                plus.add(n);
            }
        }
        int max;
        if (minus.isEmpty()) {
            max = plus.peek();
        } else if (plus.isEmpty()) {
            max = Math.abs(minus.peek());
        } else max = Math.max(Math.abs(minus.peek()), plus.peek());
        int result = 0;
        while (!minus.isEmpty()) {
            int v = Math.abs(minus.poll());
            for (int i = 0; i < M - 1; i++) {
                if (minus.isEmpty()) break;
                minus.poll();
            }
            result += v * 2;
        }
        while (!plus.isEmpty()) {
            int v = plus.poll();
            for (int i = 0; i < M - 1; i++) {
                if (plus.isEmpty()) break;
                plus.poll();
            }
            result += v * 2;
        }
        System.out.println(result - max);
    }
}