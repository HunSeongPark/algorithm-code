import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17836 {

    static int N, M, T;
    static int result = 0;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result > T ? "Fail" : result == 0 ? "Fail" : result);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, map[0][0] == 2 ? 1 : 0));
        visited[0][0][map[0][0] == 2 ? 1 : 0] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.i == N - 1 && poll.j == M - 1) {
                result = poll.w;
                break;
            }
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (!visited[x][y][1] && poll.hasGram == 1) {
                    visited[x][y][1] = true;
                    queue.add(new Node(x, y, poll.w + 1, poll.hasGram));
                } else if (!visited[x][y][0] && poll.hasGram == 0 && map[x][y] == 0) {
                    visited[x][y][0] = true;
                    queue.add(new Node(x, y, poll.w + 1, poll.hasGram));
                } else if (!visited[x][y][0] && map[x][y] == 2) {
                    visited[x][y][0] = true;
                    visited[x][y][1] = true;
                    queue.add(new Node(x, y, poll.w + 1, 1));
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int w;
        int hasGram;

        public Node(int i, int j, int w, int hasGram) {
            this.i = i;
            this.j = j;
            this.w = w;
            this.hasGram = hasGram;
        }
    }
}