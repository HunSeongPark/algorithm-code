import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2933 {

    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] col = {1, -1};
    static ArrayList<Node> clusters;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }
        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int isLeft = 0;
        for (int s = 0; s < S; s++) {
            int R = N - Integer.parseInt(st.nextToken()) + 1;
            int C = isLeft == 0 ? 1 : M;
            while (C <= M && C > 0) {
                if (map[R][C] == 'x') {
                    map[R][C] = '.';
                    for (int n = 0; n < 4; n++) {
                        int x = R + dx[n];
                        int y = C + dy[n];
                        if (x <= 0 || x > N || y <= 0 || y > M || map[x][y] == '.') continue;
                        // 클러스터 낙하
                        if (!bfs(x, y)) {
                            downCluster();
                            break;
                        }
                    }
                    break;
                }
                C += col[isLeft];
            }
            isLeft = isLeft == 0 ? 1 : 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                answer.append(map[i][j]);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    public static void downCluster() {
        Collections.sort(clusters);
        int min = Integer.MAX_VALUE;
        boolean[][] clusterMap = new boolean[N + 1][M + 1];
        for (Node cur : clusters) {
            clusterMap[cur.i][cur.j] = true;
        }
        for (Node cur : clusters) {
            int R = cur.i + 1;
            int cnt = 1;
            while (true) {
                if (R == N) break;
                if (map[R + 1][cur.j] == 'x' && !clusterMap[R + 1][cur.j]) break;
                R++;
                cnt++;
            }
            min = Math.min(min, cnt);
        }
        for (Node cur : clusters) {
            map[cur.i][cur.j] = '.';
            map[cur.i + min][cur.j] = 'x';
        }
    }

    public static boolean bfs(int i, int j) {
        clusters = new ArrayList<>();
        clusters.add(new Node(i, j));
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[i][j] = true;
        queue.add(new Node(i, j));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x <= 0 || x > N || y <= 0 || y > M || visited[x][y] || map[x][y] == '.') continue;
                if (x == N) return true;
                visited[x][y] = true;
                Node node = new Node(x, y);
                queue.add(node);
                clusters.add(node);
            }
        }
        return false;
    }

    public static class Node implements Comparable<Node> {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o) {
            return o.i - this.i;
        }
    }
}