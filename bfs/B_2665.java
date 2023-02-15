import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B_2665
{
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.del - o2.del;
            }
        });
        visited[0][0] = true;
        queue.add(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.i == N - 1 && poll.j == N - 1) {
                System.out.println(poll.del);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = poll.i + dx[i];
                int y = poll.j + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    if (map[x][y] == '0') {
                        queue.add(new Node(x, y, poll.del + 1));
                    } else {
                        queue.add(new Node(x, y, poll.del));
                    }
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int del;

        public Node (int i, int j, int del) {
            this.i = i;
            this.j = j;
            this.del = del;
        }
    }
}