import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1916 {

    public static void main(String[] args) throws IOException {
        int N, M, S, E;
        ArrayList<Edge>[] A;
        boolean[] visited;
        int[] distance;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Edge(v, w));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance[S] = 0;
        queue.add(new Edge(S, 0));
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
        System.out.println(distance[E]);
        br.close();
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