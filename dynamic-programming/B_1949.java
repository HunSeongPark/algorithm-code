import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1949 {

    static int N;
    static int[] A;
    static ArrayList<Integer>[] adj;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        adj = new ArrayList[N + 1];
        DP = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1, 0);
        System.out.println(Math.max(DP[1][0], DP[1][1]));
    }

    private static void dfs(int n, int prev) {
        DP[n][0] = 0;
        DP[n][1] = A[n];
        for (Integer i : adj[n]) {
            if (i == prev) continue;
            dfs(i, n);
            DP[n][0] += Math.max(DP[i][0], DP[i][1]);
            DP[n][1] += DP[i][0];
        }
    }
}