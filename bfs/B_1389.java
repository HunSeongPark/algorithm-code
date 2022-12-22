import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1389 {

    static int sum = 0;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] distance;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            visited = new boolean[n + 1];
            distance = new int[n + 1];
            bfs(i);
            if (sum < min) {
                min = sum;
                result = i;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void bfs(int n) {
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : A[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[poll] + 1;
                    sum += distance[i];
                    queue.add(i);
                }
            }
        }
    }
}
