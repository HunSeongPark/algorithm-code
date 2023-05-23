import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_23807 {

    static int N, M, X, Z, P;
    static int[] Ps;
    static ArrayList<Node>[] adj;
    static long[][] distance;
    static boolean[] visited;
    static long answer = Long.MAX_VALUE;

    // P 23807 https://www.acmicpc.net/problem/23807
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
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
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(br.readLine());
        distance = new long[P + 1][N + 1];
        Ps = new int[P + 1];
        Ps[0] = X;
        distance[0][X] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= P; i++) {
            Arrays.fill(distance[i], Long.MAX_VALUE);
        }
        for (int i = 1; i <= P; i++) {
            Ps[i] = Integer.parseInt(st.nextToken());
            distance[i][Ps[i]] = 0;
        }
        for (int i = 0; i <= P; i++) {
            dijkstra(i);
        }
        // TODO 백트래킹 돌려서 X -> P1 -> P2 -> P3 -> Z 최솟값 구하기
        permutation(new ArrayList<>(), 0);
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
    }

    public static void permutation(ArrayList<Integer> list, int depth) {
        if (depth == 3) {
            long dist = distance[0][Ps[list.get(0)]];
            if (dist == Long.MAX_VALUE) return;
            for (int i = 1; i < list.size(); i++) {
                if (distance[list.get(i - 1)][Ps[list.get(i)]] == Long.MAX_VALUE) return;
                dist += distance[list.get(i - 1)][Ps[list.get(i)]];
            }
            if (distance[list.get(list.size() - 1)][Z] == Long.MAX_VALUE) return;
            dist += distance[list.get(list.size() - 1)][Z];
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = 1; i <= P; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                permutation(list, depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(Ps[start], 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[start][cur.v] < cur.w) continue;
            for (Node next : adj[cur.v]) {
                if (distance[start][next.v] > cur.w + next.w) {
                    distance[start][next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, distance[start][next.v]));
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
