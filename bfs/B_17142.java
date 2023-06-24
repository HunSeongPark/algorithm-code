import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17142 {

    static int[][] map;
    static ArrayList<Node> virus = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Node> selected = new ArrayList<>();
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[virus.size()];
        combination(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs() {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (Node node : selected) {
            visited[node.i][node.j] = true;
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || copyMap[x][y] == 1) continue;
                boolean isDisable = copyMap[x][y] == 2;
                visited[x][y] = true;
                copyMap[x][y] = 2;
                if (check(copyMap)) {
                    answer = Math.min(answer, isDisable ? cur.w : cur.w + 1);
                    return;
                }
                queue.add(new Node(x, y, cur.w + 1));
            }
        }
        if (check(copyMap)) {
            answer = 0;
        }
    }

    static boolean check(int[][] copyMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void combination(int idx) {
        if (selected.size() == M) {
            bfs();
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(virus.get(i));
                combination(i + 1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }

    static class Node {
        int i;
        int j;
        int w;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Node(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
}
