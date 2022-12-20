import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1219 {

    static int N, S, E, M;
    static Edge[] edges;
    static long[] distance;
    static int[] money;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        distance = new long[N];
        money = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        distance[S] = money[S];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MIN_VALUE
                        && distance[edge.start] + (money[edge.end]) - edge.weight > distance[edge.end]) {
                    distance[edge.end] = distance[edge.start] + (money[edge.end]) - edge.weight;
                }
            }
        }
        if (distance[E] == Integer.MIN_VALUE) {
            System.out.println("gg");
            return;
        }
        boolean isCycle = false;
        for (int j = 0; j < M; j++) {
            Edge edge = edges[j];
            if (distance[edge.start] != Integer.MIN_VALUE
                    && distance[edge.start] + (money[edge.end]) - edge.weight > distance[edge.end]) {
                bfs(edge.start);
                if (visited[E]) {
                    // 사이클이 End Vertex에 도달할 경우
                    isCycle = true;
                    break;
                }
            }
        }
        if (isCycle) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[E]);
        }
        br.close();
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N];
        queue.add(n);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            List<Edge> edgeList = Arrays.stream(edges).filter(e -> e.start == poll).toList();
            for (Edge edge : edgeList) {
                if (!visited[edge.end]) {
                    queue.add(edge.end);
                }
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
