import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_9376 {

    static int T, H, W;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    static int[][] p1;
    static int[][] p2;
    static int[][] out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H + 2][W + 2];
            for (int i = 0; i < H + 2; i++) {
                Arrays.fill(map[i], '.');
            }
            p1 = new int[H + 2][W + 2];
            p2 = new int[H + 2][W + 2];
            out = new int[H + 2][W + 2];
            ArrayList<Element> p = new ArrayList<>();
            for (int i = 1; i <= H; i++) {
                String s = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = s.charAt(j - 1);
                    if (map[i][j] == '$') {
                        p.add(new Element(i, j, 0));
                    }
                }
            }
            // p1
            p1 = bfs(p.get(0).i, p.get(0).j);

            // p2
            p2 = bfs(p.get(1).i, p.get(1).j);

            // out
            out = bfs(0, 0);

            System.out.println(solve());
        }
    }

    public static long solve() {
        long min = Long.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (map[i][j] == '*') continue;
                if (p1[i][j] < 0 || p2[i][j] < 0 || out[i][j] < 0) continue;
                long sum = p1[i][j] + p2[i][j] + out[i][j];
                if (map[i][j] == '#') {
                    sum -= 2;
                }
                min = Math.min(min, sum);
            }
        }
        return min;
    }

    public static int[][] bfs(int i, int j) {
        int[][] result = new int[H + 2][W + 2];
        for (int x = 0; x < H + 2; x++) {
            Arrays.fill(result[x], -1);
        }
        boolean[][] visited = new boolean[H + 2][W + 2];
        PriorityQueue<Element> queue = new PriorityQueue<>();
        queue.add(new Element(i, j, 0));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Element poll = queue.poll();
            result[poll.i][poll.j] = poll.w;
            for (int k = 0; k < 4; k++) {
                int x = poll.i + dx[k];
                int y = poll.j + dy[k];
                if (x >= 0 && x < H + 2 && y >= 0 && y < W + 2 && !visited[x][y] && map[x][y] != '*') {
                    visited[x][y] = true;
                    queue.add(new Element(x, y, map[x][y] == '#' ? result[poll.i][poll.j] + 1 : result[poll.i][poll.j]));
                }
            }
        }
        return result;
    }

    public static class Element implements Comparable<Element> {
        int i;
        int j;
        int w;

        public Element(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public int compareTo(Element o) {
            return this.w - o.w;
        }
    }

}