import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13549 {

    static int N, K;
    static boolean[] visited;
    static Queue<Edge> queue = new LinkedList<>();
    static int max = 100_000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[max + 1];
        queue.add(new Edge(N, 0));
        bfs();
        System.out.println(min);
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            visited[poll.vertex] = true;
            if (poll.vertex == K) {
                min = Math.min(min, poll.weight);
            }
            if (poll.vertex * 2 <= max && !visited[poll.vertex * 2]) {
                queue.add(new Edge(poll.vertex * 2, poll.weight));
            }
            if (poll.vertex + 1 <= max && !visited[poll.vertex + 1]) {
                queue.add(new Edge(poll.vertex + 1, poll.weight + 1));
            }
            if (poll.vertex - 1 >= 0 && !visited[poll.vertex - 1]) {
                queue.add(new Edge(poll.vertex - 1, poll.weight + 1));
            }
        }
    }

    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}