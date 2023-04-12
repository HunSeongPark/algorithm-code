import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12100 {

    static int N;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static final int TOP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map, 0);
        System.out.println(answer);
    }

    public static void dfs(int[][] map, int depth) {
        if (depth == 5) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            answer = Math.max(answer, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            dfs(move(map, i), depth + 1);
        }
    }

    public static int[][] move(int[][] map, int dir) {
        boolean[][] merged = new boolean[N][N];
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i] = map[i].clone();
        }

        if (dir == TOP) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    int x = i;
                    int y = j;
                    while (true) {
                        int prevX = x;
                        int prevY = y;
                        x += dx[dir];
                        y += dy[dir];
                        if (x < 0 || x >= N || y < 0 || y >= N || merged[x][y]) break;
                        if (result[x][y] == 0) {
                            result[x][y] = result[prevX][prevY];
                            result[prevX][prevY] = 0;
                        } else if (result[x][y] == result[prevX][prevY]) {
                            merged[x][y] = true;
                            result[x][y] *= 2;
                            result[prevX][prevY] = 0;
                            break;
                        }
                    }
                }
            }
        } else if (dir == LEFT) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 0) continue;
                    int x = i;
                    int y = j;
                    while (true) {
                        int prevX = x;
                        int prevY = y;
                        x += dx[dir];
                        y += dy[dir];
                        if (x < 0 || x >= N || y < 0 || y >= N || merged[x][y]) break;
                        if (result[x][y] == 0) {
                            result[x][y] = result[prevX][prevY];
                            result[prevX][prevY] = 0;
                        } else if (result[x][y] == result[prevX][prevY]) {
                            merged[x][y] = true;
                            result[x][y] *= 2;
                            result[prevX][prevY] = 0;
                            break;
                        }
                    }
                }
            }
        } else if (dir == DOWN) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    int x = i;
                    int y = j;
                    while (true) {
                        int prevX = x;
                        int prevY = y;
                        x += dx[dir];
                        y += dy[dir];
                        if (x < 0 || x >= N || y < 0 || y >= N || merged[x][y]) break;
                        if (result[x][y] == 0) {
                            result[x][y] = result[prevX][prevY];
                            result[prevX][prevY] = 0;
                        } else if (result[x][y] == result[prevX][prevY]) {
                            merged[x][y] = true;
                            result[x][y] *= 2;
                            result[prevX][prevY] = 0;
                            break;
                        }
                    }
                }
            }
        } else {
            for (int j = N - 1; j >= 0; j--) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 0) continue;
                    int x = i;
                    int y = j;
                    while (true) {
                        int prevX = x;
                        int prevY = y;
                        x += dx[dir];
                        y += dy[dir];
                        if (x < 0 || x >= N || y < 0 || y >= N || merged[x][y]) break;
                        if (result[x][y] == 0) {
                            result[x][y] = result[prevX][prevY];
                            result[prevX][prevY] = 0;
                        } else if (result[x][y] == result[prevX][prevY]) {
                            merged[x][y] = true;
                            result[x][y] *= 2;
                            result[prevX][prevY] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}