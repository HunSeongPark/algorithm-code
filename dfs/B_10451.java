import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_10451 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            A = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                A[i] = new ArrayList<>();
                A[i].add(Integer.parseInt(st.nextToken()));
            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    count++;
                    dfs(i);
                }
            }
            System.out.println(count);
        }
        br.close();
    }

    private static void dfs(int n) {
        visited[n] = true;
        for (Integer i : A[n]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}