import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2573 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int year = 0;
    static int count = 0;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
            return;
        }
        while (count > 0) {
            year++;
            result = 0;
            visited = new boolean[N][M];
            update();
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        if (result > 0) {
                            System.out.println(year);
                            return;
                        } else {
                            result++;
                            bfs(i, j);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (!visited[x][y] && map[x][y] != 0) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y));
                }
            }
        }
    }

    public static void update() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 || visited[i][j]) continue;
                for (int n = 0; n < 4; n++) {
                    int x = i + dx[n];
                    int y = j + dy[n];
                    if (x < 0 || x >= N || y < 0 || y >= M) continue;
                    if (map[x][y] != 0) {
                        map[x][y]--;
                        if (map[x][y] == 0) {
                            visited[x][y] = true;
                            count--;
                        }
                    }
                }
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