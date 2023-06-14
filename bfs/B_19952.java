import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_19952 {

    static int[][] map;
    static int T, N, M, O, F, startX, startY, endX, endY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            map = new int[N + 1][M + 1];
            for (int i = 0; i < O; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                map[x][y] = h;
            }
            bfs();
        }
        System.out.print(answer);
    }

    public static void bfs() {
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, F));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.i == endX && cur.j == endY) {
                answer.append("잘했어!!").append("\n");
                return;
            }
            if (cur.w == 0) continue;
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                // MAP 범위 밖 or 이미 방문
                if (x <= 0 || x > N || y <= 0 || y > M || visited[x][y]) continue;
                // 힘 부족
                if (cur.w < map[x][y] - map[cur.i][cur.j]) continue;
                visited[x][y] = true;
                queue.add(new Node(x, y, cur.w - 1));
            }
        }
        answer.append("인성 문제있어??").append("\n");
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
