import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_8980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Node[] box = new Node[M];
        int[] capacity = new int[N + 1];
        Arrays.fill(capacity, T);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            box[i] = new Node(x, y, w);
        }
        Arrays.sort(box);
        int result = 0;
        for (int i = 0; i < M; i++) {
            Node cur = box[i];
            int value = cur.w;
            for (int j = cur.i; j < cur.j; j++) {
                if (capacity[j] < cur.w) {
                    value = Math.min(value, capacity[j]);
                }
            }
            result += value;
            for (int j = cur.i; j < cur.j; j++) {
                capacity[j] -= value;
            }
        }
        System.out.println(result);
    }

    public static class Node implements Comparable<Node> {
        int i;
        int j;
        int w;

        public Node(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if (this.j == o.j) {
                return this.i - o.i;
            }
            return this.j - o.j;
        }
    }
}