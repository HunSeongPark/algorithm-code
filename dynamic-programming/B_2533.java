import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2533 {

    /**
     * 1. 현재 노드가 얼리어답터라면
     *   -> 자식노드는 얼리어답터 일수도 아닐수도 있음 (자식노드의 자식들이 있을 수 있으므로)
     * 2. 현재 노드가 얼리어답터가 아니라면
     *   -> 자식노드는 모두 얼리어답터여야함
     */

    static int N;
    static int[][] DP;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(DP[i], -1);
        }
        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1);
        System.out.println(Math.min(DP[1][0], DP[1][1]));
    }

    public static void dfs(int n) {
        DP[n][0] = 0;
        DP[n][1] = 1;
        for (Integer next : adj[n]) {
            if (DP[next][0] == -1) {
                dfs(next);
                DP[n][0] += DP[next][1];
                DP[n][1] += Math.min(DP[next][0], DP[next][1]);
            }
        }
    }
}