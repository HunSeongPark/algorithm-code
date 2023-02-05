import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5:13
public class B_2146 {

    static int N;
    static int[][] map;
    static int idx = 2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    markLand(i, j);
                    idx++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);
    }

    public static void bfs(int i, int j) {
        int color = map[i][j];
        visited = new boolean[N][N];
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (map[poll.i][poll.j] != color && map[poll.i][poll.j] != 0) {
                min = Math.min(min, poll.w - 1);
                return;
            }
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (map[x][y] != color && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, poll.w + 1));
                }
            }
        }
    }

    public static void markLand(int i, int j) {
        map[i][j] = idx;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (map[x][y] == 1) {
                    map[x][y] = idx;
                    queue.add(new Node(x, y, 0));
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