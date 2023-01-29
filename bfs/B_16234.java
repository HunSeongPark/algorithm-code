import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = 0;
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            isEnd = true;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
            if (isEnd) {
                System.out.println(result);
                return;
            } else {
                result++;
            }
        }
    }

    public static void bfs(int i, int j) {
        ArrayList<Node> union = new ArrayList<>();
        int sum = map[i][j];
        union.add(new Node(i, j));
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && Math.abs(map[poll.i][poll.j] - map[x][y]) >= L && Math.abs(map[poll.i][poll.j] - map[x][y]) <= R) {
                    visited[x][y] = true;
                    sum += map[x][y];
                    union.add(new Node(x, y));
                    queue.add(new Node(x, y));
                }
            }
        }
        if (union.size() > 1) {
            isEnd = false;
            int value = sum / union.size();
            for (Node node : union) {
                map[node.i][node.j] = value;
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