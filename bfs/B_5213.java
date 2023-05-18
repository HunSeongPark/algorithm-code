import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_5213 {

    public static int N, max = 0, idx = 1;
    public static int[][] map, level;
    public static Node maxNode = null;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N * 2];
        level = new int[N][N * 2];
        for (int i = 0; i < N; i++) {
            int j = i % 2 == 0 ? 0 : 1;
            for (int k = 0; k < N; k++) {
                if (k == N - 1 && i % 2 == 1) break;
                st = new StringTokenizer(br.readLine());
                level[i][j] = idx;
                map[i][j++] = Integer.parseInt(st.nextToken());
                level[i][j] = idx++;
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        StringBuilder answer = new StringBuilder();
        answer.append(maxNode.root.size()).append("\n");
        for (Integer i : maxNode.root) {
            answer.append(i).append(" ");
        }
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N * 2];
        visited[0][0] = true;
        visited[0][1] = true;
        ArrayList<Integer> initRoot = new ArrayList<>();
        initRoot.add(1);
        queue.add(new Node(0, 0, initRoot));
        queue.add(new Node(0, 1, initRoot));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (level[cur.i][cur.j] > max) {
                max = level[cur.i][cur.j];
                maxNode = cur;
            }
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= N * 2 || visited[x][y] || level[x][y] == level[cur.i][cur.j]) continue;
                if (map[cur.i][cur.j] == map[x][y]) {
                    visited[x][y] = true;
                    ArrayList<Integer> root = new ArrayList<>(cur.root);
                    root.add(level[x][y]);
                    queue.add(new Node(x, y, root));
                    if (y - 1 >= 0 && !visited[x][y - 1] && level[x][y - 1] == level[x][y]) {
                        visited[x][y - 1] = true;
                        queue.add(new Node(x, y - 1, root));
                    } else if (y + 1 < N * 2 && !visited[x][y + 1] && level[x][y + 1] == level[x][y]){
                        visited[x][y + 1] = true;
                        queue.add(new Node(x, y + 1, root));
                    }
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        ArrayList<Integer> root;

        public Node(int i, int j, ArrayList<Integer> root) {
            this.i = i;
            this.j = j;
            this.root = root;
        }
    }
}
