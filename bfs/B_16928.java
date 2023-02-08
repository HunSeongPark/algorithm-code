import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16928 {

    static boolean[] visited = new boolean[101];
    static int[] distance = new int[101];
    static int[] A = new int[101];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[101];
        for (int i = 0; i < 101; i++) {
            A[i] = i;
        }
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u] = v;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == 100) {
                System.out.println(distance[100]);
                return;
            }
            for (int i = 1; i < 7; i++) {
                int dest = poll + i;
                if (dest > 100 || visited[A[dest]]) continue;
                if (distance[A[dest]] == 0) {
                    queue.add(A[dest]);
                    distance[A[dest]] = distance[poll] + 1;
                }
            }
        }
    }
}