import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14284 {

    static int N, M, S, T;
    static int[] distance;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[T]);
    }

    public static void dijkstra() {
        distance[S] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(S, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (distance[cur.v] < cur.w) continue;
            for (Node next : adj[cur.v]) {
                if (distance[next.v] > cur.w + next.w) {
                    distance[next.v] = cur.w + next.w;
                    queue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    public static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}