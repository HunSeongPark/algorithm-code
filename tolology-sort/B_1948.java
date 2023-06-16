import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1948 {

    static int[] distance, indegree;
    static int N, M, S, E, count = 0;
    static ArrayList<Node>[] adj;
    static ArrayList<Node>[] adj_reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        indegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        adj_reverse = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            adj_reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, W));
            adj_reverse[B].add(new Node(A, W));
            indegree[B]++;
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        topology_dijkstra();
        findEdgeCount();
        System.out.println(distance[E]);
        System.out.println(count);
    }

    public static void topology_dijkstra() {
        Queue<Node> queue = new LinkedList<>();
        distance[S] = 0;
        queue.add(new Node(S, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : adj[cur.n]) {
                if (distance[next.n] < cur.w + next.w) {
                    distance[next.n] = cur.w + next.w;
                }
                indegree[next.n]--;
                if (indegree[next.n] == 0) {
                    queue.add(new Node(next.n, distance[next.n]));
                }
            }
        }
    }

    public static void findEdgeCount() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(E);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node prev : adj_reverse[cur]) {
                if (!visited[cur][prev.n] && distance[prev.n] == distance[cur] - prev.w) {
                    count++;
                    visited[cur][prev.n] = true;
                    queue.add(prev.n);
                }
            }
        }
    }

    public static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
