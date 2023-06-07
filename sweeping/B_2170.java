import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long E = Long.parseLong(st.nextToken());
            nodes[i] = new Node(S, E);
        }
        Arrays.sort(nodes);
        long answer = nodes[0].E - nodes[0].S;
        long R = nodes[0].E;
        for (int i = 1; i < N; i++) {
            long curL = nodes[i].S;
            long curR = nodes[i].E;
            if (R < curR) {
                if (curL <= R) {
                    answer += curR - R;
                } else {
                    answer += curR - curL;
                }
                R = curR;
            }
        }
        System.out.println(answer);
    }

    public static class Node implements Comparable<Node> {
        long S;
        long E;

        public Node(long S, long E) {
            this.S = S;
            this.E = E;
        }

        @Override
        public int compareTo(Node o) {
            if (this.S == o.S) {
                return Long.compare(this.E, o.E);
            }
            return Long.compare(this.S, o.S);
        }
    }
}
