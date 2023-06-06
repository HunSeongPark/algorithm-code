import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2836 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long E = Long.parseLong(st.nextToken());
            if (S > E) {
                nodes.add(new Node(S, E));
            }
        }
        Collections.sort(nodes);
        long L = nodes.get(0).E;
        long R = nodes.get(0).S;
        long len = R - L;
        for (int i = 1; i < nodes.size(); i++) {
            Node cur = nodes.get(i);
            if (R < cur.S && R >= cur.E) {
                len += cur.S - R;
                R = cur.S;
            } else if (cur.E > R) {
                len += cur.S - cur.E;
                R = cur.S;
            }
        }
        System.out.println(M + len * 2);
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
            if (this.E == o.E) {
                return Long.compare(this.S, o.S);
            }
            return Long.compare(this.E, o.E);
        }
    }
}
