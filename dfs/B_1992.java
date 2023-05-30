import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1992 {

    static StringBuilder answer = new StringBuilder();
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int prev = map[0][0];
        boolean isFill = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (prev != map[i][j]) {
                    isFill = false;
                    break;
                }
            }
        }
        if (isFill) {
            System.out.println(prev);
            return;
        }
        answer.append("(");
        dfs(0, 0, N / 2);
        dfs(0, N / 2, N / 2);
        dfs(N / 2, 0, N / 2);
        dfs(N / 2, N / 2, N / 2);
        answer.append(")");
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int size) {
        if (size == 1) {
            answer.append(map[x][y]);
            return;
        }
        int prev = map[x][y];
        boolean isFill = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (prev != map[i][j]) {
                    isFill = false;
                    break;
                }
            }
        }
        if (isFill) {
            answer.append(prev);
        } else {
            answer.append("(");
            dfs(x, y, size / 2);
            dfs(x, y + size / 2, size / 2);
            dfs(x + size / 2, y, size / 2);
            dfs(x + size / 2, y + size / 2, size / 2);
            answer.append(")");
        }
    }
}
