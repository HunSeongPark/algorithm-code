import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4179 {

    public static int result = -1;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean[][] map;
    public static int R, C;
    public static Node J;
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R + 1][C + 1];
        // map을 벗어난 첫번째 열/행 방문처리
        for (int i = 0; i <= R; i++) {
            map[i][0] = true;
        }
        for (int i = 0; i <= C; i++) {
            map[0][i] = true;
        }
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                char ch = s.charAt(j - 1);
                // 벽은 이동 불가
                if (ch == '#') {
                    map[i][j] = true;
                }
                // 지훈이 위치
                if (ch == 'J') {
                    // 이미 미로의 끝이라면 한번만 이동하면 탈출
                    if (i == 1 || j == 1 || i == R || j == C) {
                        System.out.println(1);
                        return;
                    }
                    J = new Node(i, j, 0);
                    map[i][j] = true;
                }
                // 불인경우 먼저 이동하므로 큐에 넣음
                if (ch == 'F') {
                    queue.add(new Node(i, j, -1));
                    map[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    public static void bfs() {
        queue.add(J);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 상하좌우 확인
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                // map을 넘어서는 경우 continue
                if (x > R || y > C) continue;
                // 방문하지 않은 위치인 경우
                if (!map[x][y]) {
                    // 방문 처리
                    map[x][y] = true;
                    // 불이 아닌 경우
                    if (cur.c != -1) {
                        // 다음 위치 미로 끝 여부 확인
                        if (x == 1 || y == 1 || x == R || y == C) {
                            // 다음위치(+1) / 다음위치에서 한번 더 이동 (+1)
                            result = cur.c + 2;
                            return;
                        } else {
                            // 현재 위치 이동횟수 + 1 큐에 삽입
                            queue.add(new Node(x, y, cur.c + 1));
                        }
                    } else {
                        // 불인 경우 큐에 바로 삽입
                        queue.add(new Node(x, y, -1));
                    }
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int c;

        public Node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }
}