import java.io.*;
import java.util.*;

public class B_1744 {

    static int N;
    static PriorityQueue<Integer> p_queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
    static Queue<Integer> z_queue = new LinkedList<>();
    static Queue<Integer> one_queue = new LinkedList<>();
    static PriorityQueue<Integer> n_queue = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        int result = 0;
        while (true) {
            if (p_queue.size() <= 1) break;
            result += p_queue.poll() * p_queue.poll();
        }
        if (p_queue.size() == 1) {
            result += p_queue.poll();
        }
        result += one_queue.size();
        while (true) {
            if (n_queue.size() <= 1) break;
            result += n_queue.poll() * n_queue.poll();
        }
        if (n_queue.size() == 1) {
            if (z_queue.size() >= 1) {
                result += n_queue.poll() * z_queue.poll();
            } else {
                result += n_queue.poll();
            }
        }
        System.out.println(result);
        clear();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 1) {
                p_queue.add(n);
            } else if (n < 0) {
                n_queue.add(n);
            } else if (n == 0) {
                z_queue.add(n);
            } else {
                one_queue.add(n);
            }
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}