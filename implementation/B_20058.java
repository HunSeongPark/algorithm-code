import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20058 {

    static int Q, N, sum, max, cur;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[] pow = new int[7];

    /**
     * 상하좌우 0 개수 2개 이상이면 얼음 -1
     * 가장 큰 덩어리가 차지하는 칸의 개수 = 인접한 얼음의 개수 중 최대 (dfs)
     */
    // 10 43
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pow[1] = 2;
        for (int i = 2; i <= 6; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        N = pow[Integer.parseInt(st.nextToken())];
        Q = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int q = 0; q < Q; q++) {
            int L = pow[Integer.parseInt(st.nextToken())];
            // Rotate
            for (int i = 0; i < N; i += L) {
                for (int j = 0; j < N; j += L) {
                    rotate(i, j, L);
                }
            }
            // checkIce
            checkIce();
        }
        bfs();
        System.out.println(sum);
        System.out.println(max);
    }

    public static void rotate(int startI, int startJ, int L) {
        int[][] original = new int[N][N];
        for (int i = 0; i < N; i++) original[i] = map[i].clone();

        int x = startI;
        int y = startJ + L - 1;
        for (int i = startI; i < startI + L; i++) {
            for (int j = startJ; j < startJ + L; j++) {
                map[x++][y] = original[i][j];
                if (x == startI + L) {
                    y--;
                    x = startI;
                }
            }
        }
    }

    public static void checkIce() {
        int[][] original = new int[N][N];
        for (int i = 0; i < N; i++) original[i] = map[i].clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                int count = 0;
                for (int n = 0; n < 4; n++) {
                    int x = i + dx[n];
                    int y = j + dy[n];
                    if (x < 0 || x >= N || y < 0 || y >= N || original[x][y] == 0) continue;
                    count++;
                }
                if (count < 3) map[i][j]--;
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
                if (map[i][j] > 0 && !visit[i][j]) {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    int cnt = 1;

                    while (!q.isEmpty()) {
                        int[] t = q.poll();
                        int tx = t[0];
                        int ty = t[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = tx + dx[k];
                            int ny = ty + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (map[nx][ny] > 0 && !visit[nx][ny]) {
                                    visit[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                    cnt++;
                                }
                            }
                        }

                    }
                    max = Math.max(max, cnt);
                }
            }
        }
    }
}
