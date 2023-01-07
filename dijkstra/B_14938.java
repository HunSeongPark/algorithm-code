import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14938 {

    static int[] item;
    static int[] distance;
    static ArrayList<Edge>[] adj;
    static int n, m, r;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        distance = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (distance[poll.idx] < poll.weight) {
                continue;
            }
            for (Edge edge : adj[poll.idx]) {
                if (distance[edge.idx] > distance[poll.idx] + edge.weight) {
                    distance[edge.idx] = distance[poll.idx] + edge.weight;
                    queue.add(new Edge(edge.idx, distance[edge.idx]));
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] <= m) {
                result += item[i];
            }
        }
        max = Math.max(max, result);
    }

    private static class Edge implements Comparable<Edge> {
        int idx;
        int weight;

        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}