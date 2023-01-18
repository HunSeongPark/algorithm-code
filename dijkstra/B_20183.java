import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_20183 {

    static int N, M, A, B;
    static long C;
    static ArrayList<Node>[] adj;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        adj = new ArrayList[N + 1];
        distance = new long[N + 1];
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
        long start = 1;
        long end = 1000000001;
        long result = end;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (dijkstra(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (result == 1000000001) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static boolean dijkstra(long x) {
        for (int i = 1; i <= N; i++) {
            distance[i] = Long.MAX_VALUE;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(A, 0));
        distance[A] = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (distance[poll.v] != poll.w) continue;
            for (Node node : adj[poll.v]) {
                if (node.w <= x && distance[node.v] > distance[poll.v] + node.w) {
                    distance[node.v] = distance[poll.v] + node.w;
                    queue.add(new Node(node.v, distance[node.v]));
                }
            }
        }
        return C >= distance[B];
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
            if (this.w > o.w) return 1;
            else if (this.w == o.w) return 0;
            return -1;
        }
    }
}