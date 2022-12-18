import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606 {

    static int N, E, count = 0;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        bfs();
        System.out.println(count);
        br.close();
    }

    private static void bfs() {
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : A[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }
    }
}