import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Flower> queue = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s_month = Integer.parseInt(st.nextToken());
            int s_day = Integer.parseInt(st.nextToken());
            int e_month = Integer.parseInt(st.nextToken());
            int e_day = Integer.parseInt(st.nextToken());
            queue.add(new Flower(s_month, s_day, e_month, e_day));
        }
        Flower curFlower = queue.poll();
        if (!isMarch(curFlower.start_month, curFlower.start_day)) {
            System.out.println(0);
            return;
        }
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            Flower flower = queue.peek();
            if (isMarch(flower.start_month, flower.start_day)) {
                if (isFast(curFlower.end_month, curFlower.end_day, flower.end_month, flower.end_day)) {
                    curFlower = queue.poll();
                } else {
                    queue.poll();
                }
            } else {
                break;
            }
        }
        if (queue.size() == N) {
            System.out.println(0);
            return;
        }
        int result = 1;
        while (!queue.isEmpty()) {
            if (isLast(curFlower.end_month, curFlower.end_day)) break;
            Flower updateFlower = queue.poll();
            if (isFast(curFlower.end_month, curFlower.end_day, updateFlower.start_month, updateFlower.start_day)) {
                System.out.println(0);
                return;
            }
            while (!queue.isEmpty()) {
                Flower peek = queue.peek();
                if (isFast(curFlower.end_month, curFlower.end_day, peek.start_month, peek.start_day)) {
                    break;
                }
                if (isFast(updateFlower.end_month, updateFlower.end_day, peek.end_month, peek.end_day)) {
                    updateFlower = queue.poll();
                } else {
                    queue.poll();
                }
            }
            result++;
            curFlower = updateFlower;
        }
        if (isLast(curFlower.end_month, curFlower.end_day)) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isFast(int m1, int d1, int m2, int d2) {
        if (m1 == m2) {
            return d1 < d2;
        }
        return m1 < m2;
    }

    public static boolean isMarch(int m, int d) {
        return (m == 3 && d == 1) || (m <= 2);
    }

    public static boolean isLast(int m, int d) {
        return m == 12;
    }

    public static class Flower implements Comparable<Flower> {
        int start_month;
        int start_day;
        int end_month;
        int end_day;

        public Flower(int start_month, int start_day, int end_month, int end_day) {
            this.start_month = start_month;
            this.start_day = start_day;
            this.end_month = end_month;
            this.end_day = end_day;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start_month == o.start_month) {
                if (this.start_day == o.start_day) {
                    if (this.end_month == o.end_month) {
                        return o.end_day - this.end_day;
                    } else {
                        return o.end_month - this.end_month;
                    }
                } else {
                    return this.start_day - o.start_day;
                }
            } else {
                return this.start_month - o.start_month;
            }
        }
    }
}