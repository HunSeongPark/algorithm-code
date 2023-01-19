import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1504 {

    static int N, E, A, B;
    static ArrayList<Node>[] adj;
    static int[] distance;
    static boolean[] visited;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int result1 = distance[A];
        int result2 = distance[B];

        dijkstra(A);
        result1 += distance[B];
        dijkstra(B);
        result1 += distance[N];

        dijkstra(B);
        result2 += distance[A];
        dijkstra(A);
        result2 += distance[N];

        int ans = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(ans);
    }

    public static void dijkstra(int start) {
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.v]) continue;
            visited[poll.v] = true;
            for (Node node : adj[poll.v]) {
                if (distance[node.v] > distance[poll.v] + node.w) {
                    distance[node.v] = distance[poll.v] + node.w;
                    queue.add(new Node(node.v, distance[node.v]));
                }
            }
        }
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