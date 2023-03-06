import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2:45
public class B_15683 {

    static int N, M;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Node> cctv = new ArrayList<>();
    static final int XPLUS = 0;
    static final int XMINUS = 1;
    static final int YPLUS = 2;
    static final int YMINUS = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] != '0' && map[i][j] != '6') {
                    cctv.add(new Node(i, j, map[i][j]));
                }
            }
        }
        dfs(0, map.clone());
        System.out.println(answer);
    }

    public static void dfs(int idx, char[][] copy) {
        if (idx == cctv.size()) {
            int result = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (copy[x][y] == '0') result++;
                }
            }
            answer = Math.min(answer, result);
            return;
        }
        Node cur = cctv.get(idx);
        if (cur.type == '1') {
            dfs(idx + 1, rotateCctv(cur.i, cur.j, copy, XPLUS));
            dfs(idx + 1, rotateCctv(cur.i, cur.j, copy, XMINUS));
            dfs(idx + 1, rotateCctv(cur.i, cur.j, copy, YPLUS));
            dfs(idx + 1, rotateCctv(cur.i, cur.j, copy, YMINUS));
        } else if (cur.type == '2') {
            char[][] result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, XMINUS));
            result = rotateCctv(cur.i, cur.j, copy, YPLUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YMINUS));
        } else if (cur.type == '3') {
            char[][] result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YMINUS));
            result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YPLUS));
            result = rotateCctv(cur.i, cur.j, copy, XMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YPLUS));
            result = rotateCctv(cur.i, cur.j, copy, XMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YMINUS));
        } else if (cur.type == '4') {
            char[][] result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            result = rotateCctv(cur.i, cur.j, result, XMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YPLUS));
            result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            result = rotateCctv(cur.i, cur.j, result, XMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YMINUS));
            result = rotateCctv(cur.i, cur.j, copy, YPLUS);
            result = rotateCctv(cur.i, cur.j, result, YMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, XPLUS));
            result = rotateCctv(cur.i, cur.j, copy, YPLUS);
            result = rotateCctv(cur.i, cur.j, result, YMINUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, XMINUS));
        } else {
            char[][] result = rotateCctv(cur.i, cur.j, copy, XPLUS);
            result = rotateCctv(cur.i, cur.j, result, XMINUS);
            result = rotateCctv(cur.i, cur.j, result, YPLUS);
            dfs(idx + 1, rotateCctv(cur.i, cur.j, result, YMINUS));
        }
    }

    public static char[][] rotateCctv(int i, int j, char[][] copy, int rotate) {
        char[][] result = new char[N][M];
        int index = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                result[x][y] = copy[x][y];
            }
        }
        if (rotate == XPLUS) {
            while (i + index < N && result[i + index][j] != '6') {
                result[i + index][j] = '#';
                index++;
            }
        } else if (rotate == XMINUS) {
            while (i - index >= 0 && result[i - index][j] != '6') {
                result[i - index][j] = '#';
                index++;
            }
        } else if (rotate == YPLUS) {
            while (j + index < M && result[i][j + index] != '6') {
                result[i][j + index] = '#';
                index++;
            }
        } else {
            while (j - index >= 0 && result[i][j - index] != '6') {
                result[i][j - index] = '#';
                index++;
            }
        }
        return result;
    }

    public static class Node {
        int i;
        int j;
        char type;

        public Node(int i, int j, char type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    }
}