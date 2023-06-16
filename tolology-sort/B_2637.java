import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2637 {

    static int[] indegree, outdegree, count;
    static int N, M;
    static ArrayList<Node>[] adj;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        outdegree = new int[N + 1];
        count = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            adj[X].add(new Node(Y, K));
            indegree[X]++;
            outdegree[Y]++;
        }
        topologySort();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) answer.append(i).append(" ").append(count[i]).append("\n");
        }
        System.out.println(answer);
    }

    public static void topologySort() {
        count[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node next : adj[cur]) {
                count[next.n] += count[cur] * next.w;
                outdegree[next.n]--;
                if (outdegree[next.n] == 0) queue.add(next.n);
            }
        }
    }

    public static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
