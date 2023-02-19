import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_17396 {

    static int N, M;
    static long[] distance;
    static ArrayList<Node>[] adj;
    static boolean[] isWard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N];
        isWard = new boolean[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            isWard[i] = st.nextToken().equals("1");
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (isWard[a] || isWard[b]) continue;
            adj[a].add(new Node(b, t));
            adj[b].add(new Node(a, t));
        }
        Arrays.fill(distance, Long.MAX_VALUE);
        dijkstra();
        System.out.println(distance[N - 1] == Long.MAX_VALUE ? -1 : distance[N - 1]);
    }

    public static void dijkstra() {
        distance[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (distance[curNode.idx] < curNode.weight) continue;
            for (Node nextNode : adj[curNode.idx]) {
                if (distance[nextNode.idx] > nextNode.weight + curNode.weight) {
                    distance[nextNode.idx] = nextNode.weight + curNode.weight;
                    queue.add(new Node(nextNode.idx, distance[nextNode.idx]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int idx;
        long weight;

        public Node(int idx, long weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight == o.weight) {
                return 0;
            } else if (this.weight > o.weight) {
                return 1;
            }
            return -1;
        }
    }
}