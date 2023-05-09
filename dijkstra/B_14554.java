import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14554 {

    static int N, M, S, E;
    static ArrayList<Node>[] adj;
    static long answer = 0;
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }
        dijkstra();
        System.out.println(answer);
    }

    public static void dijkstra() {
        long[] distance = new long[N + 1];
        long[] count = new long[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[S] = 0;
        count[S] = 1;
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > distance[cur.v] || cur.v == E) continue;
            for (Node next : adj[cur.v]) {
                // 더 빠른 경로 발견
                if (distance[next.v] > next.w + cur.w) {
                    distance[next.v] = next.w + cur.w;
                    count[next.v] = count[cur.v];
                    pq.add(new Node(next.v, distance[next.v]));
                } else if (distance[next.v] == next.w + cur.w) {
                    // 같은 거리의 경로
                    count[next.v] = (count[next.v] + count[cur.v]) % MOD;
                }
            }
        }
        answer = count[E];
    }

    public static class Node implements Comparable<Node>{
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.w - o.w);
        }
    }
}