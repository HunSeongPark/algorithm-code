import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2636 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int hour = 0;
    static int cheeze = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Node> removeCheeze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '1') {
                    cheeze++;
                }
            }
        }
        while (cheeze > 0) {
            removeCheeze = new ArrayList<>();
            visited = new boolean[N][M];
            bfs();
            cheeze -= removeCheeze.size();
            for (Node node : removeCheeze) {
                map[node.i][node.j] = '0';
            }
            hour++;
        }
        System.out.println(hour);
        System.out.println(removeCheeze.size());
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (map[x][y] == '1' && !visited[x][y]) {
                    removeCheeze.add(new Node(x, y));
                } else if (map[x][y] == '0' && !visited[x][y]){
                    queue.add(new Node(x, y));
                }
                visited[x][y] = true;
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