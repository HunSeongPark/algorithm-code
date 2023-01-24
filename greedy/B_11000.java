import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Recture[] rectures = new Recture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            rectures[i] = new Recture(s, t);
        }

        Arrays.sort(rectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(rectures[0].t);

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= rectures[i].s) {
                queue.poll();
            }
            queue.add(rectures[i].t);
        }

        System.out.println(queue.size());
    }

    public static class Recture implements Comparable<Recture> {
        int s;
        int t;

        public Recture(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Recture o) {
            if (this.s == o.s) {
                return this.t - o.t;
            }
            return this.s - o.s;
        }
    }
}