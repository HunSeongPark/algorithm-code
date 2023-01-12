import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] time = new int[R][C];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = {0, -1, 0, 1 };
        for (int i = 0; i < R; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = str[j];
                if (str[j] == 'O') {
                    time[i][j] = 3;
                }
            }
        }
        for (int n = 2; n <= N; n++) {
            if (n % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        map[i][j] = 'O';
                        if (time[i][j] == 0) {
                            time[i][j] = n + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (time[i][j] == n) {
                            time[i][j] = 0;
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (x >= 0 && x < R && y >= 0 && y < C && time[x][y] != n) {
                                    time[x][y] = 0;
                                    map[x][y] = '.';
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}