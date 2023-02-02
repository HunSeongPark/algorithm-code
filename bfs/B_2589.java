import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 6:55
public class B_2589 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }
        System.out.println(result);
    }

    public static int bfs(int i, int j) {
        visited = new boolean[N][M];
        visited[i][j] = true;
        int result = 0;
        Queue<Node> queue =new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (!visited[x][y] && map[x][y] == 'L') {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, poll.w + 1));
                    result = Math.max(result, poll.w + 1);
                }
            }
        }
        return result;
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