import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12:30
public class B_10775 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        int[] g = new int[P];
        for (int i = 0; i < P; i++) {
            g[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for (int i = 0; i < P; i++) {
            int p = find(g[i]);
            if (p == 0) break;
            union(p, p - 1);
            answer++;
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}