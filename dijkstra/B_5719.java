import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_5719
{
    static int N, M, S, D;
    static ArrayList<Node>[] adj;
    static ArrayList<Integer>[] removeNodes;
    static StringBuilder answer = new StringBuilder();
    static int[] distance;
    static boolean[][] check;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N + M == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            distance = new int[N];
            check = new boolean[N][N];
            removeNodes = new ArrayList[N];
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                removeNodes[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, w));
            }
            dijkstra();
            removeShortestEdge(D);
            dijkstra();
            answer.append(distance[D] == Integer.MAX_VALUE ? -1 : distance[D]).append("\n");
        }
        System.out.println(answer);
    }

    public static void dijkstra() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(S, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.w > distance[cur.v]) continue;
            for (Node next : adj[cur.v]) {
                if (check[cur.v][next.v]) continue;
                if (distance[next.v] > cur.w + next.w) {
                    removeNodes[next.v].clear();
                    removeNodes[next.v].add(cur.v);
                    distance[next.v] = cur.w + next.w;
                    queue.add(new Node(next.v, distance[next.v]));
                } else if (distance[next.v] == cur.w + next.w) {
                    removeNodes[next.v].add(cur.v);
                }
            }
        }
    }
    public static void removeShortestEdge(int v) {
        if (v == S) return;
        for (Integer i : removeNodes[v]) {
            if (!check[i][v]) {
                check[i][v] = true;
                removeShortestEdge(i);
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}