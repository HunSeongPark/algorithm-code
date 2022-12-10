import java.io.*;
import java.util.PriorityQueue;

public class B_1715 {

    static int N;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int result = 0;
        while (true) {
            if (N == 1) {
                break;
            } else if (N == 2) {
                result = queue.poll() + queue.poll();
                break;
            }
            int num1 = queue.poll();
            int num2 = queue.poll();
            result += num1 + num2;
            if (queue.isEmpty()) break;
            queue.add(num1 + num2);
        }
        System.out.println(result);
        clear();
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
    }

    private static void clear() throws IOException {
        br.close();
    }
}