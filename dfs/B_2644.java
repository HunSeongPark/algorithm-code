import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2644 {

    public static int N, S, E, M;
    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(S, 0);
        System.out.println(answer);
    }

    public static void dfs(int u, int depth) {
        if (u == E) {
            answer = depth;
            return;
        }
        if (visited[u]) return;
        visited[u] = true;
        for (Integer v : adj[u]) {
            dfs(v, depth + 1);
        }
    }
}