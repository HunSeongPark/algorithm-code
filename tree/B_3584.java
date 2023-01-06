import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3584 {

    static int N;
    static int[][] parent;
    static int[] depth;
    static ArrayList<Integer>[] child;
    static int A, B;
    static final int MAX = baseLog(2, 100000);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            depth = new int[N + 1];
            Arrays.fill(depth, -1);
            parent = new int[N + 1][MAX];
            child = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                child[i] = new ArrayList<>();
            }
            StringTokenizer st;
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int pa = Integer.parseInt(st.nextToken());
                int ch = Integer.parseInt(st.nextToken());
                child[pa].add(ch);
                parent[ch][0] = pa;
            }
            int root = 0;
            for (int i = 1; i <= N; i++) {
                if (parent[i][0] == 0) {
                    root = i;
                    depth[i] = 0;
                    break;
                }
            }
            make_tree(root);
            for (int j = 0; j < MAX - 1; j++) {
                for (int i = 1; i <= N; i++) {
                    parent[i][j + 1] = parent[parent[i][j]][j];
                }
            }
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (depth[A] < depth[B]) {
                int tmp = A;
                A = B;
                B = tmp;
            }
            int diff = depth[A] - depth[B];
            for (int j = 0; ; j++) {
                if (diff <= 0) break;
                if (diff % 2 == 1) {
                    A = parent[A][j];
                }
                diff /= 2;
            }
            if (A != B) {
                for (int j = MAX - 1; j >= 0; j--) {
                    if (parent[A][j] != 0 && parent[A][j] != parent[B][j]) {
                        A = parent[A][j];
                        B = parent[B][j];
                    }
                }
                System.out.println(parent[A][0]);
            } else {
                System.out.println(A);
            }
        }
    }

    private static void make_tree(int n) {
        for (Integer i : child[n]) {
            if (depth[i] == -1) {
                depth[i] = depth[n] + 1;
                make_tree(i);
            }
        }
    }

    private static int baseLog(double base, double x) {
        return (int) Math.ceil(Math.log(x) / Math.log(base));
    }
}