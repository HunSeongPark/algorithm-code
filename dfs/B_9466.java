import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9466 {

    static int N, count;
    static int[] parent;
    static boolean[] visited, end;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            end = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                parent[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i);
            }
            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int v) {
        visited[v] = true;
        int next = parent[v];
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!end[next]) {
                count++;
                for (int i = parent[next]; i != next; i = parent[i]) {
                    count++;
                }
            }
        }
        end[v] = true;
    }
}
