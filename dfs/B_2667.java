import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2667 {

    static int count = 0;
    static int N;
    static char[][] A;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (!visited[i][j] && A[i][j] == '1') {
                    dfs(i, j);
                    if (count > 0) {
                        result.add(count);
                    }
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }
    private static void dfs(int i, int j) {
        visited[i][j] = true;
        count++;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < N && x >= 0 && y < N && y >= 0 && !visited[x][y] && A[x][y] == '1') {
                dfs(x, y);
            }
        }
    }
}