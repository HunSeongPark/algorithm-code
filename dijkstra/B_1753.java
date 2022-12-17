import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1753 {

    public static void main(String[] args) throws IOException {
        int V, E, K;
        ArrayList<Edge>[] A;
        boolean[] visited;
        int[] distance;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            if (i != K) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Edge(v, w));
        }
        queue.add(new Edge(K, 0));
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (visited[poll.vertex]) {
                continue;
            }
            visited[poll.vertex] = true;
            for (Edge edge : A[poll.vertex]) {
                if (distance[edge.vertex] > distance[poll.vertex] + edge.weight) {
                    distance[edge.vertex] = distance[poll.vertex] + edge.weight;
                    queue.add(new Edge(edge.vertex, distance[edge.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}