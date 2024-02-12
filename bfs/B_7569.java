import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569 {

    static int[][][] map;
    static int[] dn = {-1, 0, 1, 0, 0, 0};
    static int[] dm = {0, -1, 0, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int N, M, H, count, day = -1;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        // +2 하여 앞뒤 NPE 방어
        map = new int[H + 2][N + 2][M + 2];
        // -1로 map 초기화
        for (int h = 0; h <= H + 1; h++) {
            for (int n = 0; n <= N + 1; n++) {
                Arrays.fill(map[h][n], -1);
            }
        }
        // input
        for (int h = 1; h <= H; h++) {
            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 1; m <= M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    // 익지 않은 토마토 count
                    if (map[h][n][m] == 0) {
                        count++;
                    }
                    // 익은 토마토 enqueue
                    if (map[h][n][m] == 1) {
                        queue.add(new Node(0, h, n, m));
                    }
                }
            }
        }
        // 익지 않은 토마토가 없는 경우 0 출력
        if (count == 0) {
            System.out.println(0);
            return;
        }
        // BFS
        bfs();
        // 결과 출력
        System.out.println(day);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 현재 위치 기준 여섯 방향 토마토 확인
            for (int i = 0; i < 6; i++) {
                int h = cur.h + dh[i];
                int n = cur.n + dn[i];
                int m = cur.m + dm[i];
                // 해당 토마토가 익지 않은 경우
                if (map[h][n][m] == 0) {
                    // count 감소 & 토마토 익히기
                    count--;
                    map[h][n][m] = 1;
                    // count = 0인 경우 모든 토마토가 익은 경우로 종료
                    if (count == 0) {
                        day = cur.day + 1;
                        return;
                    }
                    // 종료 아닌 경우 day + 1, 현재 위치 enqueue
                    queue.add(new Node(cur.day + 1, h, n, m));
                }
            }
        }
    }

    public static class Node {
        int day;
        int h;
        int n;
        int m;

        public Node(int day, int h, int n, int m) {
            this.day = day;
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}