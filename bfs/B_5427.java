import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_5427 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w,h;
    static char[][] map;
    static Queue<Node> queue;
    static Queue<Node> fire;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            answer = -1;
            queue = new LinkedList<>();
            fire = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '*') {
                        fire.add(new Node(i, j, 0));
                    }
                    if (map[i][j] == '@') {
                        queue.add(new Node(i, j, 0));
                    }
                }
            }
            bfs();
            System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            // 불 이동
            int length = fire.size();
            for (int i = 0; i < length; i++) {
                Node poll = fire.poll();
                for (int n = 0; n < 4; n++) {
                    int x = poll.i + dx[n];
                    int y = poll.j + dy[n];
                    if (x < 0 || x >= h || y < 0 || y >= w) continue;
                    if (map[x][y] == '.') {
                        map[x][y] = '*';
                        fire.add(new Node(x, y, poll.t + 1));
                    }
                }
            }
            // 상근 이동
            length = queue.size();
            for (int i = 0; i < length; i++) {
                Node poll = queue.poll();
                if (poll.i == 0 || poll.j == 0 || poll.i == h - 1 || poll.j == w - 1) {
                    answer = poll.t + 1;
                    return;
                }
                for (int n = 0; n < 4; n++) {
                    int x = poll.i + dx[n];
                    int y = poll.j + dy[n];
                    if (x < 0 || x >= h || y < 0 || y >= w) continue;
                    if (map[x][y] == '.') {
                        map[x][y] = '@';
                        queue.add(new Node(x, y, poll.t + 1));
                    }
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int t;

        public Node(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}