import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17822 {

    static int[][] map;
    static int N, M, T;

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
            }
        }
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int i = x - 1; i < N; i += x) {
                rotate(i, d, k);
            }
            if (!findAdj()) {
                updateAvg();
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void rotate(int i, int d, int k) {
        int[] copy = map[i].clone();
        for (int j = 0; j < M; j++) {
            // 시계
            if (d == 0) {
                if (j - k < 0) {
                    map[i][j] = copy[M + (j - k)];
                } else {
                    map[i][j] = copy[j - k];
                }
            } else {
                // 반시계
                map[i][j] = copy[(j + k) % M];
            }
        }
    }

    public static boolean findAdj() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        boolean isFind = false;
        // inner
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == M - 1) {
                    if (copy[i][j] != 0 && copy[i][j] == copy[i][0]) {
                        map[i][j] = map[i][0] = 0;
                        isFind = true;
                    }
                } else {
                    if (copy[i][j] != 0 && copy[i][j] == copy[i][j + 1]) {
                        map[i][j] = map[i][j + 1] = 0;
                        isFind = true;
                    }
                }
            }
        }
        // outer
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (copy[i][j] != 0 && copy[i][j] == copy[i + 1][j]) {
                    map[i][j] = map[i + 1][j] = 0;
                    isFind = true;
                }
            }
        }
        return isFind;
    }

    public static void updateAvg() {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
                if (map[i][j] != 0) count++;
            }
        }
        double avg = sum / count;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                if (map[i][j] < avg) {
                    map[i][j]++;
                } else if (map[i][j] > avg) {
                    map[i][j]--;
                }
            }
        }
    }
}