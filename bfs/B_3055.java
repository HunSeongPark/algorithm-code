import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3055 {

    static int N;
    static int M;
    static char[][] map;
    static int[][] water;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        water = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                water[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    updateWater(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    bfs(i, j);
                }
            }
        }
        System.out.println("KAKTUS");
    }

    public static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (map[poll.i][poll.j] == 'D') {
                System.out.println(poll.minute);
                System.exit(0);
            }
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (water[x][y] != Integer.MAX_VALUE && water[x][y] <= poll.minute + 1) continue;
                if (!visited[x][y] && map[x][y] != 'X') {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, poll.minute + 1));
                }
            }
        }
    }

    public static void updateWater(int i, int j) {
        water[i][j] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = poll.i + dx[n];
                int y = poll.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (map[x][y] == '.' && water[x][y] > poll.minute + 1) {
                    water[x][y] = poll.minute + 1;
                    queue.add(new Node(x, y, poll.minute + 1));
                }
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int minute;

        public Node(int i, int j, int minute) {
            this.i = i;
            this.j = j;
            this.minute = minute;
        }
    }
}
