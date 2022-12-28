import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15651 {

    static int N;
    static int M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }
        System.out.println(sb);
    }

    private static void dfs(int num, int depth) {
        result[depth] = num;
        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            dfs(i, depth + 1);
        }
    }
}
