import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15681 {

    static int N, R, Q;
    static ArrayList<Integer>[] child;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        child = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, 1);
        for (int i = 1; i <= N; i++) {
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            child[u].add(v);
            child[v].add(u);
        }
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(result[n]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        visited[n] = true;
        for (Integer i : child[n]) {
            if (!visited[i]) {
                dfs(i);
                result[n] += result[i];
            }
        }
    }
}