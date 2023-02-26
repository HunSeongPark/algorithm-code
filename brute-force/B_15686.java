import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 3:38
public class B_15686 {

    static int N, M;
    static int[][] map;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> home = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int cur) {
        if (cur ==  M) {
            checkDistance();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cur + 1);
                visited[i] = false;
            }
        }
    }

    public static void checkDistance() {
        int distance = 0;
        for (Node curHome : home) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < chicken.size(); k++) {
                if (visited[k]) {
                    Node curChicken = chicken.get(k);
                    min = Math.min(min, Math.abs(curHome.i - curChicken.i) + Math.abs(curHome.j - curChicken.j));
                }
            }
            distance += min;
        }
        answer = Math.min(answer, distance);
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