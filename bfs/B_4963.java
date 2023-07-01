import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4963 {

    static int N, M, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            count = 0;
            if (N + M == 0) break;
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int n = 0; n < 8; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] == 0) continue;
                visited[x][y] = true;
                queue.add(new Node(x, y));
            }
        }
    }

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
