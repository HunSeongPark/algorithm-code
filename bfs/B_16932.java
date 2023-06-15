import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16932 {

    static int N, M, answer, idx = 1, count;
    static int[][] map;
    static Queue<Node> zeroQueue = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> list = new ArrayList<>();
    static HashMap<Integer, Integer> cntMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        list.add(-1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroQueue.add(new Node(i, j));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    bfs(i, j, idx);
                    answer = Math.max(answer, count);
                    list.add(count);
                    idx++;
                }
            }
        }
        Set<Integer> indexSet;
        while (!zeroQueue.isEmpty()) {
            Node cur = zeroQueue.poll();
            indexSet = new HashSet<>();
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 0) continue;
                indexSet.add(map[x][y]);
            }
            int sum = 1;
            for (Integer index : indexSet) {
                sum += list.get(index);
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j, int idx) {
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        map[i][j] = idx;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 0 || visited[x][y]) continue;
                visited[x][y] = true;
                map[x][y] = idx;
                count++;
                queue.add(new Node(x, y));
            }
        }
    }

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
