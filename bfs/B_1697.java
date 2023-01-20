import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697 {

    static int N;
    static int K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[100001];
        queue.add(new Node(N, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.n]) continue;
            visited[poll.n] = true;
            if (poll.n == K) {
                System.out.println(poll.s);
                break;
            }
            if (poll.n + 1 <= 100000) {
                queue.add(new Node(poll.n + 1, poll.s + 1));
            }
            if (poll.n - 1 >= 0) {
                queue.add(new Node(poll.n - 1, poll.s + 1));
            }
            if (poll.n * 2 <= 100000) {
                queue.add(new Node(poll.n * 2, poll.s + 1));
            }
        }
    }

    public static class Node {
        int n;
        int s;

        public Node(int n, int s) {
            this.n = n;
            this.s = s;
        }
    }
}