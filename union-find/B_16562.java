import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16562 {

    static int[] parent;
    static int[] cost;
    static int[] minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        cost = new int[N + 1];
        minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            minCost[root] = Math.min(minCost[root], cost[i]);
        }
        int answer = 0;
        for (Integer c : minCost) {
            if (c == Integer.MAX_VALUE) continue;
            answer += c;
        }
        if (answer > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(answer);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
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