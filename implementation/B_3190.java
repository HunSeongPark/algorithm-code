import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3190 {

    static int N, K, L;
    static boolean[][] map;
    static Map<Integer, String> dir = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static LinkedList<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            dir.put(t, st.nextToken());
        }
        int time = 0;
        int cx = 1;
        int cy = 1;
        int idx = 0;
        snake.add(new int[]{1, 1});
        while (true) {
            time++;
            cx += dx[idx];
            cy += dy[idx];
            if (isEnd(cx, cy)) break;
            snake.add(new int[]{cx, cy});
            if (map[cx][cy]) {
                map[cx][cy] = false;
            } else {
                snake.remove(0);
            }
            if (dir.containsKey(time)) {
                String d = dir.get(time);
                if (d.equals("L")) {
                    idx--;
                    if (idx < 0) {
                        idx = 3;
                    }
                } else {
                    idx++;
                    if (idx > 3) {
                        idx = 0;
                    }
                }
            }
        }
        System.out.println(time);
    }

    public static boolean isEnd(int cx, int cy) {
        if (cx <= 0 || cx > N || cy <= 0 || cy > N) return true;
        for (int[] p : snake) {
            if (p[0] == cx && p[1] == cy) return true;
        }
        return false;
    }
}