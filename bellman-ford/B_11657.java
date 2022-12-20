import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11657 {

    public static void main(String[] args) throws IOException {
        int N, M;
        long[] distance;
        Edge[] edges;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        edges = new Edge[M + 1];
        for (int i = 2; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE &&
                        distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }
        boolean isCycle = false;
        for (int j = 0; j < M; j++) {
            Edge edge = edges[j];
            if (distance[edge.start] != Integer.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.weight) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
        br.close();
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
