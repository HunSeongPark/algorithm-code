import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1325 {

    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    static int[] reliable;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(reliable[i], max);
        }
        for (int i = 1; i <= N; i++) {
            if (reliable[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
        clear();
    }

    public static void bfs(int n) {
        visited[n] = true;
        queue.add(n);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : A[poll]) {
                if (!visited[i]) {
                    reliable[i]++;
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
        A = new ArrayList[N + 1];
        reliable = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}