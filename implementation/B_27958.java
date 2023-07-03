import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_27958 {

    static int N, K;
    static int[][] map;
    static int[] power;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        power = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }
        permutation(new ArrayList<>());
        System.out.println(answer);
    }

    public static int shoot(ArrayList<Integer> bullets) {
        int[][] original = new int[N][N];
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            original[i] = map[i].clone();
            copy[i] = map[i].clone();
        }
        int ret = 0;
        for (int i = 0; i < K; i++) {
            int bullet = bullets.get(i);
            for (int j = 0; j < N; j++) {
                if (copy[bullet][j] > 0) {
                    // bonus
                    if (copy[bullet][j] >= 10) {
                        copy[bullet][j] = 0;
                        ret += original[bullet][j];
                    } else {
                        copy[bullet][j] -= power[i];
                        if (copy[bullet][j] <= 0) {
                            copy[bullet][j] = 0;
                            ret += original[bullet][j];
                            if (original[bullet][j] / 4 == 0) break;
                            for (int n = 0; n < 4; n++) {
                                int x = bullet + dx[n];
                                int y = j + dy[n];
                                if (x < 0 || x >= N || y < 0 || y >= N || copy[x][y] > 0) continue;
                                copy[x][y] = original[bullet][j] / 4;
                                original[x][y] = original[bullet][j] / 4;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return ret;
    }

    public static void permutation(ArrayList<Integer> bullets) {
        if (bullets.size() == K) {
            answer = Math.max(answer, shoot(bullets));
            return;
        }
        for (int i = 0; i < N; i++) {
            bullets.add(i);
            permutation(bullets);
            bullets.remove(bullets.size() - 1);
        }
    }
}
