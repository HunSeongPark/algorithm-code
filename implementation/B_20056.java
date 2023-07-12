import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_20056 {

    static ArrayList<Ball>[][] map;
    static ArrayList<Ball> balls = new ArrayList<>();
    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            balls.add(new Ball(r, c, m, d, s));
        }
        for (int i = 0; i < K; i++) {
            move();
            mergeAndDivide();
            updateBalls();
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!map[i][j].isEmpty()) {
                    for (Ball ball : map[i][j]) {
                        answer += ball.m;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void move() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (Ball ball : balls) {
            int i = ball.r + dx[ball.d] * (ball.s % N);
            int j = ball.c + dy[ball.d] * (ball.s % N);

            if (i <= 0) {
                i = N - Math.abs(i);
            } else if (i > N) {
                i %= N;
            }
            if (j <= 0) {
                j = N - Math.abs(j);
            } else if (j > N) {
                j %= N;
            }

            map[i][j].add(new Ball(i, j, ball.m, ball.d, ball.s));
        }
    }

    public static void mergeAndDivide() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() > 1) {
                    int mSum = 0, sSum = 0;
                    boolean isOdd = true, isEven = true;
                    for (Ball ball : map[i][j]) {
                        mSum += ball.m;
                        sSum += ball.s;
                        if (ball.d % 2 == 0) isOdd = false;
                        if (ball.d % 2 == 1) isEven = false;
                    }
                    int size = map[i][j].size();
                    map[i][j].clear();
                    if (mSum / 5 <= 0) continue;
                    for (int d = 0; d <= 6; d += 2) {
                        map[i][j].add(new Ball(i, j, mSum / 5, d + (isEven || isOdd ? 0 : 1), sSum / size));
                    }
                }
            }
        }
    }

    public static void updateBalls() {
        balls.clear();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!map[i][j].isEmpty()) {
                    balls.addAll(map[i][j]);
                }
            }
        }
    }



    public static class Ball {
        int r;
        int c;
        int m;
        int d;
        int s;

        public Ball(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
}
