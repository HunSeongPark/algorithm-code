import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11437 {

    static int N, M, K;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }
        depth = new int[N + 1];
        parent = new int[N + 1][K];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1, 1);
        updateParent();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            answer.append(lcs(u, v)).append("\n");
        }
        System.out.println(answer);
    }

    public static void dfs(int v, int dep) {
        depth[v] = dep;
        for (Integer i : adj[v]) {
            if (depth[i] == 0) {
                dfs(i, dep + 1);
                parent[i][0] = v;
            }
        }
    }

    public static void updateParent() {
        for (int i = 1; i < K; i++) {
            for (int v = 1; v <= N; v++) {
                parent[v][i] = parent[parent[v][i - 1]][i - 1];
            }
        }
    }

    public static int lcs(int u, int v) {
        if (depth[u] > depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[v] - depth[u]) {
                v = parent[v][i];
            }
        }
        if (u == v) return u;
        for (int i = K - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }
}
