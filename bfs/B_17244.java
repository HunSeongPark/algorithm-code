import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17244 {

    static int N, M;
    static ArrayList<Node> nodes = new ArrayList<>();
    static Node start = null;
    static Node end = null;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'X') {
                    nodes.add(new Node(i, j));
                }
                if (map[i][j] == 'S') {
                    start = new Node(i, j);
                    map[i][j] = 'X';
                }
                if (map[i][j] == 'E') {
                    end = new Node(i, j);
                    map[i][j] = 'X';
                }
            }
        }
        nodes.add(0, start);
        nodes.add(nodes.size(), end);
        dist = new int[nodes.size()][nodes.size()];
        visited = new boolean[nodes.size()];
        for (int i = 0; i < nodes.size() - 1; i++) {
            bfs(nodes.get(i), i);
        }
        if (nodes.size() == 2) {
            System.out.println(dist[0][1]);
            return;
        }
        permutation(new ArrayList<>());
        System.out.println(answer);
    }

    public static void permutation(ArrayList<Integer> selected) {
        if (selected.size() == nodes.size() - 2) {
            int sum = dist[0][selected.get(0)];
            for (int i = 1; i < selected.size(); i++) {
                sum += dist[selected.get(i - 1)][selected.get(i)];
            }
            sum += dist[selected.get(selected.size() - 1)][nodes.size() - 1];
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 1; i < nodes.size() - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(i);
                permutation(selected);
                selected.remove(selected.get(selected.size() - 1));
                visited[i] = false;
            }
        }
    }

    public static void bfs(Node start, int idx) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        int cnt = nodes.size();
        queue.add(start);
        v[start.i][start.j] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (map[cur.i][cur.j] == 'X') {
                int curIdx = findIdx(cur.i, cur.j);
                dist[idx][curIdx] = cur.w;
                cnt--;
                if (cnt == 0) break;
                if (curIdx == nodes.size() - 1) continue;
            }
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M || v[x][y] || map[x][y] == '#') continue;
                v[x][y] = true;
                queue.add(new Node(x, y, cur.w + 1));
            }
        }
    }

    public static int findIdx(int i, int j) {
        for (int idx = 0; idx < nodes.size(); idx++) {
            if (i == nodes.get(idx).i && j == nodes.get(idx).j) return idx;
        }
        return -1;
    }

    public static class Node {
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
