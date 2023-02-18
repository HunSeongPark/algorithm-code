import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_5972 {

    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }
        dijkstra();
    }

    public static void dijkstra() {
        distance[1] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (distance[poll.v] < poll.w) continue;
            for (Node node : adj[poll.v]) {
                if (distance[node.v] > poll.w + node.w) {
                    distance[node.v] = poll.w + node.w;
                    queue.add(new Node(node.v, distance[node.v]));
                }
            }
        }
        System.out.println(distance[N]);
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}