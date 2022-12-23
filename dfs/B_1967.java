import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1967 {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int longest = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V;
        V = Integer.parseInt(br.readLine());
        if (V == 1) {
            System.out.println(0);
            return;
        }
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < V - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }
        dfs(1, 0);
        visited = new boolean[V + 1];
        max = 0;
        dfs(longest, 0);
        System.out.println(max);
    }

    private static void dfs(int n, int weight) {
        visited[n] = true;
        if (weight > max) {
            max = weight;
            longest = n;
        }
        for (Node node : tree[n]) {
            if (!visited[node.v]) {
                dfs(node.v, weight + node.w);
            }
        }
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
