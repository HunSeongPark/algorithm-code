import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11725 {

    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
        br.close();
    }

    private static void dfs(int n) {
        visited[n] = true;
        for (Integer i : A[n]) {
            if (!visited[i]) {
                parent[i] = n;
                dfs(i);
            }
        }
    }
}
