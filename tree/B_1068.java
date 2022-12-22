import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1068 {

    static int N, K;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                A[p].add(i);
            } else {
                root = i;
            }
        }
        K = Integer.parseInt(br.readLine());
        if (K == root) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(result);
    }

    private static void dfs(int n) {
        visited[n] = true;
        if (A[n].size() == 0) result++;
        for (Integer i : A[n]) {
            if (!visited[i] && i != K) {
                    dfs(i);
            } else if (i == K) {
                if (A[n].size() == 1) {
                    result++;
                }
            }
        }
    }
}
