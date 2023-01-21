import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {

    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }
        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[2][N][M];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = 10000000;
            }
        }
        queue.add(new Node(0, 0, 0));
        distance[0][0] = 1;
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (map[x][y] == 0 && !visited[poll.w][x][y]) {
                        visited[poll.w][x][y] = true;
                        distance[x][y] = distance[poll.i][poll.j] + 1;
                        queue.add(new Node(x, y, poll.w));
                    } else if (map[x][y] == 1) {
                        if (poll.w == 0 && !visited[1][x][y]) {
                            visited[1][x][y] = true;
                            distance[x][y] = distance[poll.i][poll.j] + 1;
                            queue.add(new Node(x, y, 1));
                        }
                    }
                    if (x == N - 1 && y == M - 1) {
                        System.out.println(distance[x][y]);
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static class Node {
        int i;
        int j;
        int w;

        public Node(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
}