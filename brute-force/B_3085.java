import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3085 {

    static int N;
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        check();
        if (answer == N) {
            System.out.println(N);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char tmp = map[i][j];
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = tmp;
                    check();
                    map[i][j + 1] = map[i][j];
                    map[i][j] = tmp;
                }
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = tmp;
                    check();
                    map[i + 1][j] = map[i][j];
                    map[i][j] = tmp;
                }
            }
        }
        System.out.println(answer);
    }

    public static void check() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            char cur = 'P';
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (cur == map[i][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                    cur = map[i][j];
                }
            }
            max = Math.max(max, count);
        }
        for (int j = 0; j < N; j++) {
            char cur = 'P';
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (cur == map[i][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                    cur = map[i][j];
                }
            }
            max = Math.max(max, count);
        }
        answer = Math.max(answer, max);
    }
}