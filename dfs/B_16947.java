import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16947 {

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] cycle;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adj = new ArrayList[N + 1];
        cycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            cycle[i] = true;
            if (dfs(i, i, i)) break;
            cycle[i] = false;
        }
        for (int i = 1; i <= N; i++) {
            if (cycle[i]) {
                answer.append(0).append(" ");
            } else {
                bfs(i);
            }
        }
        System.out.println(answer);
    }

    public static boolean dfs(int start, int cur, int prev) {
        for (Integer i : adj[cur]) {
            if (cycle[i] && i == start && i != prev) {
                return true;
            }
            if (!cycle[i]) {
                cycle[i] = true;
                if (dfs(start, i, cur)) return true;
                cycle[i] = false;
            }
        }
        return false;
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cycle[cur.v]) {
                answer.append(cur.w).append(" ");
                break;
            }
            for (Integer next : adj[cur.v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, cur.w + 1));
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