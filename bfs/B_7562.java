import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562 {

    static int T;
    static int N;
    static int result = 0;
    static int[] night = new int[2];
    static int[] end = new int[2];
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            night[0] = Integer.parseInt(st.nextToken());
            night[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            bfs();
            System.out.println(result);
        }
    }

    public static void bfs() {
        visited[night[0]][night[1]] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(night[0], night[1], 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.i == end[0] && poll.j == end[1]) {
                result = poll.w;
                break;
            }
            for (int n = 0; n < 8; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, poll.w + 1));
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