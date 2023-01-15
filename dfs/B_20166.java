import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class B_20166 {

    static int N, M, K;
    static String str;
    static char[][] map;
    static HashMap<String, Integer> result = new LinkedHashMap<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String mapStr = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = mapStr.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, "" + map[i][j], 1);
            }
        }
        for (int t = 0; t < K; t++) {
            str = br.readLine();
            sb.append(result.get(str) == null ? 0 : result.get(str)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int i, int j, String curStr, int depth) {
        if (result.containsKey(curStr)) {
            result.put(curStr, result.get(curStr) + 1);
        } else {
            result.put(curStr, 1);
        }
        if (depth == 5) return;
        for (int k = 0; k < 8; k++) {
            int x = (i + dx[k]) % N;
            int y = (j + dy[k]) % M;
            if (x < 0) x += N;
            if (y < 0) y += M;
            dfs(x, y, curStr + map[x][y], depth + 1);
        }
    }
}