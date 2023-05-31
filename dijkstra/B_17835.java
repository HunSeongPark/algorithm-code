import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_17835 {

    static int N, M, K;
    static HashSet<Integer> dest = new HashSet<>();
    static long[] distance;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        distance = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            dest.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer i : dest) {
            distance[i] = Long.MAX_VALUE;
        }
        dijkstra();
        int answerIdx = 0;
        long answerMax = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == Long.MAX_VALUE) continue;
            if (distance[i] > answerMax) {
                answerIdx = i;
                answerMax = distance[i];
            }
        }
        System.out.println(answerIdx);
        System.out.println(answerMax);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Integer i : dest) {
            pq.add(new Node(i, 0));
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > distance[cur.v]) continue;
            for (Node next : adj[cur.v]) {
                if (dest.contains(next.v)) continue;
                if (distance[next.v] > cur.w + next.w) {
                    distance[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
}