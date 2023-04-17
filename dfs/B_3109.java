import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3109 {

    static char[][] map;
    static int R, C;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean dfs(int i, int j) {
        map[i][j] = 'x';

        if (j == C - 1) return true;
        if (i - 1 >= 0 && map[i - 1][j + 1] == '.' && dfs(i - 1, j + 1)) return true;
        if (map[i][j + 1] == '.' && dfs(i, j + 1)) return true;
        if (i + 1 < R && map[i + 1][j + 1] == '.' && dfs(i + 1, j + 1)) return true;
        return false;
    }
}