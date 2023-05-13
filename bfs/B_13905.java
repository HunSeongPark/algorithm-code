import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_13905 {

    static int N, M, S, E;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w, 0));
            adj[v].add(new Node(u, w, 0));
        }
        bfs();
        System.out.println(0);
    }

    public static void bfs() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0, Integer.MAX_VALUE));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.v == E) {
                System.out.println(cur.min);
                System.exit(0);
            }
            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            for (Node next : adj[cur.v]) {
                pq.add(new Node(next.v, 0, Math.min(cur.min, next.w)));
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;
        int min;

        public Node(int v, int w, int min) {
            this.v = v;
            this.w = w;
            this.min = min;
        }

        @Override
        public int compareTo(Node o) {
            return o.min - this.min;
        }
    }
}