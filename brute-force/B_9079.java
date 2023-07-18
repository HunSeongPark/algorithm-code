import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9079 {

    static final int MAX = (1 << 9) - 1;
    static StringBuilder answer = new StringBuilder();
    static int[][] flip = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    // H = 1 & T = 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int init = 0;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    init *= 2;
                    if (st.nextToken().equals("H")) {
                        init++;
                    }
                }
            }
            answer.append(bfs(init)).append("\n");
        }
        System.out.println(answer);
    }

    public static int bfs(int init) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<Node> queue = new LinkedList<>();
        visited[init] = true;
        queue.add(new Node(init, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.n == MAX || cur.n == 0) {
                return cur.count;
            }
            for (int i = 0; i < 8; i++) {
                int n = cur.n;
                for (int idx : flip[i]) {
                    n ^= 1 << idx;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(new Node(n, cur.count + 1));
                }
            }
        }
        return -1;
    }

    public static class Node {
        int n;
        int count;

        public Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
