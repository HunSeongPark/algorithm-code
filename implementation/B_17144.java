import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17144 {

    static int N, M, T;
    static int[] air = new int[2];
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && air[1] == 0) {
                    air[0] = i;
                    air[1] = i + 1;
                }
            }
        }
        for (int t = 0; t < T; t++) {
            spread();
            run();
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void spread() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] > 0) {
                    int count = 0;
                    for (int n = 0; n < 4; n++) {
                        int x = i + dx[n];
                        int y = j + dy[n];
                        if (x < 0 || x >= N || y < 0 || y >= M || copy[x][y] == -1) continue;
                        count++;
                        map[x][y] += copy[i][j] / 5;
                    }
                    map[i][j] -= copy[i][j] / 5 * count;
                }
            }
        }
    }

    public static void run() {

        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        // top (반시계)
        map[air[0]][1] = 0;
        for (int j = 2; j < M; j++) {
            map[air[0]][j] = copy[air[0]][j - 1];
        }
        map[air[0] - 1][M - 1] = copy[air[0]][M - 1];
        for (int i = air[0] - 2; i >= 0; i--) {
            map[i][M - 1] = copy[i + 1][M - 1];
        }
        for (int j = M - 2; j >= 0; j--) {
            map[0][j] = copy[0][j + 1];
        }
        if (air[0] != 1 && air[1] != 1) map[1][0] = copy[0][0];
        for (int i = 2; i < air[0]; i++) {
            map[i][0] = copy[i - 1][0];
        }


        // bottom (시계)
        map[air[1]][1] = 0;
        for (int j = 2; j < M; j++) {
            map[air[1]][j] = copy[air[1]][j - 1];
        }
        map[air[1] + 1][M - 1] = copy[air[1]][M - 1];
        for (int i = air[1] + 2; i < N; i++) {
            map[i][M - 1] = copy[i - 1][M - 1];
        }
        for (int j = M - 2; j >= 0; j--) {
            map[N - 1][j] = copy[N - 1][j + 1];
        }
        if (air[0] != N - 2 && air[1] != N - 2) map[N - 2][0] = copy[N - 1][0];
        for (int i = N - 3; i > air[1]; i--) {
            map[i][0] = copy[i + 1][0];
        }
    }
}