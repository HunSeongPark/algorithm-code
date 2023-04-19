import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1600 {

    static int K, N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {0, -1, 0, 1, -2, -1, 1, 2, 2, 1, -1, -2};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][K] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, K));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.i == N - 1 && cur.j == M - 1) {
                answer = cur.w;
                break;
            }
            int seq = cur.k > 0 ? 12 : 4;
            for (int n = 0; n < seq; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                int k = n > 3 ? cur.k - 1 : cur.k;
                if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 1 || visited[x][y][k]) continue;
                visited[x][y][k] = true;
                queue.add(new Node(x, y, cur.w + 1, k));
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int w;
        int k;

        public Node(int i, int j, int w, int k) {
            this.i = i;
            this.j = j;
            this.w = w;
            this.k = k;
        }
    }
}