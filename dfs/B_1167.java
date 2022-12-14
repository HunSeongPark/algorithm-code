import java.io.*;
import java.util.*;

/**
 * 트리의 지름 구하기
 * 1. 임의의 한 점(v = 1)에 대해 dfs 수행
 * 2. dfs의 결과로 v = 1에서 가장 거리가 먼 점(cur_vertex) 반환
 * 3. cur_vertex에 대해 dfs 수행
 * 4. cur_vertex에서 가장 거리가 먼 weight 출력
 */
public class B_1167 {

    static int V;
    static ArrayList<Node>[] A;
    static int cur_max = -1;
    static int cur_vertex;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, 0);
        cur_max = -1;
        dfs(cur_vertex, 0);
        System.out.println(cur_max);
        clear();
    }

    public static void dfs(int n, int depth) {
        if (depth > cur_max) {
            cur_max = depth;
            cur_vertex = n;
        }

        visited[n] = true;
        for (Node node : A[n]) {
            if (!visited[node.v]) {
                dfs(node.v, depth + node.w);
            }
        }
        visited[n] = false;
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            A[cur] = new ArrayList<>();
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                A[cur].add(new Node(v, w));
            }
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}