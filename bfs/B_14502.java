import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_14502 {

    static int max = 0;
    static int N;
    static int M;
    static int[][] A;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                    dfs(cnt + 1);
                    A[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = A[i].clone();
        }
        Queue<Element> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 2) {
                    queue.add(new Element(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Element e = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = e.x + dx[i];
                int y = e.y + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < M && copy[x][y] == 0) {
                    copy[x][y] = 2;
                    queue.add(new Element(x, y));
                }
            }
        }
        calcMaxVirus(copy);
    }

    private static void calcMaxVirus(int[][] copy) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }

    private static class Element {
        int x;
        int y;

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}