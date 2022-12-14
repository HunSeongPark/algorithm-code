import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_13023 {

    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (result) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        clear();
    }

    private static void dfs(int n, int depth) {
        if (depth == 5) {
            result = true;
            return;
        }
        if (visited[n]) {
            return;
        }
        visited[n] = true;
        for (int i : A[n]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[n] = false;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}