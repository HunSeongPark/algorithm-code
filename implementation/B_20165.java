import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20165 {

    static int N;
    static int M;
    static int R;
    static int[][] domino;
    static char[][] result;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        domino = new int[N + 1][M + 1];
        result = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                domino[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = 'S';
            }
        }

        // logic
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            char D = st.nextToken().charAt(0);
            attack(X, Y, D);
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            result[X][Y] = 'S';
        }

        // output
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void attack(int X, int Y, char D) {
        Queue<Pos> queue = new LinkedList<>();
        if (result[X][Y] == 'S') {
            result[X][Y] = 'F';
            sum++;
            queue.add(new Pos(X, Y));
        }
        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            for (int i = 1; i < domino[poll.x][poll.y]; i++) {
                int x = poll.x;
                int y = poll.y;
                if (D == 'E') {
                    y += i;
                } else if (D == 'W') {
                    y -= i;
                } else if (D == 'S') {
                    x += i;
                } else {
                    x -= i;
                }
                if (x >= 0 && x <= N && y >= 0 && y <= M) {
                    if (result[x][y] == 'S') {
                        sum++;
                        result[x][y] = 'F';
                        queue.add(new Pos(x, y));
                    }
                }
            }
        }
    }

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}