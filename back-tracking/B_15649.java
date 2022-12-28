import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15649 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M + 1];
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    result[depth] = i;
                    visited[i] = true;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
