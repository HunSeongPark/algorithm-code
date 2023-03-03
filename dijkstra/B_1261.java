import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1261 {

    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        dijkstra();
        System.out.println(distance[N - 1][M - 1]);
    }

    public static void dijkstra() {
        distance[0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (distance[poll.i][poll.j] < poll.w) continue;
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (distance[x][y] > poll.w + map[x][y]) {
                    distance[x][y] = poll.w + map[x][y];
                    queue.add(new Node(x, y, distance[x][y]));
                }
            }
        }
    }

    public static class Node {
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