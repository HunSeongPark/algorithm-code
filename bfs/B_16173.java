import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16173 {

    static String result = "Hing";
    static int[][] map;
    static int N;
    static final int VISITED = -2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (map[cur.x][cur.y] == -1) {
                result = "HaruHaru";
                return;
            }
            int num = map[cur.x][cur.y];
            map[cur.x][cur.y] = VISITED;
            if (cur.x + num <= N && map[cur.x + num][cur.y] != VISITED) {
                queue.add(new Node(cur.x + num, cur.y));
            }
            if (cur.y + num <= N && map[cur.x][cur.y + num] != VISITED) {
                queue.add(new Node(cur.x, cur.y + num));
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}