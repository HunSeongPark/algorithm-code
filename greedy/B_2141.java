import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            sum += a;
            nodes[i] = new Node(pos, a);
        }
        Arrays.sort(nodes);
        long curSum = 0;
        for (Node node : nodes) {
            curSum += node.a;
            if (curSum >= (sum + 1) / 2) {
                System.out.println(node.pos);
                break;
            }
        }
    }

    public static class Node implements Comparable<Node> {
        long pos;
        long a;

        public Node(long pos, long a) {
            this.pos = pos;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.pos, o.pos);
        }
    }
}