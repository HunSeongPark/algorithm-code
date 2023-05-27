import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_16724 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        parent = new int[N * M];
        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c == 'L' ? 0 : c == 'R' ? 1 : c == 'D' ? 2 : 3;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int idx = i * M + j;
                int nextIdx = (i + dx[map[i][j]]) * M + (j + dy[map[i][j]]);
                if (find(idx) != find(nextIdx)) {
                    union(idx, nextIdx);
                }
            }
        }
        Set<Integer> answer = new HashSet<>();
        for (int i = 0; i < N * M; i++) {
            answer.add(find(i));
        }
        System.out.println(answer.size());
    }

    public static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
