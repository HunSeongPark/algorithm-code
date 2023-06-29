import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_21610 {

    static int N, M, d, s;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] cross_dx = {-1, -1, 1, 1};
    static int[] cross_dy = {-1, 1, -1, 1};
    static int[][] map;
    static ArrayList<Node> clouds = new ArrayList<>();
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds.add(new Node(N, 1));
        clouds.add(new Node(N, 2));
        clouds.add(new Node(N - 1, 1));
        clouds.add(new Node(N - 1, 2));
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            moveAndRainCloud();
            checkCross();
            updateCloud();
        }
        System.out.println(answer);
    }

    public static void moveAndRainCloud() {
        visited = new boolean[N + 1][N + 1];
        for (Node cloud : clouds) {
            for (int i = 0; i < s; i++) {
                cloud.i += dx[d];
            }
            if (cloud.i > N) {
                while (cloud.i > N) cloud.i -= N;
            } else if (cloud.i <= 0) {
                while (cloud.i <= 0) cloud.i += N;
            }
            for (int i = 0; i < s; i++) {
                cloud.j += dy[d];
            }
            if (cloud.j > N) {
                while (cloud.j > N) cloud.j -= N;
            } else if (cloud.j <= 0) {
                while (cloud.j <= 0) cloud.j += N;
            }
            map[cloud.i][cloud.j]++;
            visited[cloud.i][cloud.j] = true;
        }
    }

    public static void checkCross() {
        for (Node cloud : clouds) {
            int count = 0;
            for (int n = 0; n < 4; n++) {
                int x = cloud.i + cross_dx[n];
                int y = cloud.j + cross_dy[n];
                if (x > N || x <= 0 || y > N || y <= 0) continue;
                if (map[x][y] > 0) count++;
            }
            map[cloud.i][cloud.j] += count;
        }
    }

    public static void updateCloud() {
        clouds = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -= 2;
                    clouds.add(new Node(i, j));
                }
                sum += map[i][j];
            }
        }
        answer = sum;
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