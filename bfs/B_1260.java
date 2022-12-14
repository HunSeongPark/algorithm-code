import java.io.*;
import java.util.*;

public class B_1260 {

    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
        clear();
    }

    private static void dfs(int n) {
        System.out.print(n + " ");
        visited[n] = true;
        for (int i : A[n]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (int i : A[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}