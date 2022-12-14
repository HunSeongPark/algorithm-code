import java.io.*;
import java.util.*;

public class B_2178 {

    static int N;
    static int M;
    static int[][] Q;
    static int[] cx = {-1, 0, 1, 0};
    static int[] cy = {0, -1, 0, 1};
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        bfs(1, 1);
        clear();
    }

    public static void bfs(int i, int j) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i, j});
        visited[i][j] = true;
        while (true) {
            Integer[] cur = queue.poll();
            if (cur[0] == N && cur[1] == M) {
                System.out.println(Q[N][M]);
                break;
            }
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + cx[k];
                int y = cur[1] + cy[k];
                if (x > 0 && x <= N && y > 0 && y <= M) {
                    if (!visited[x][y] && Q[x][y] == 1) {
                        Q[x][y] = Q[cur[0]][cur[1]] + 1;
                        queue.add(new Integer[]{x, y});
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                Q[i][j] = str[j - 1] - '0';
            }
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}