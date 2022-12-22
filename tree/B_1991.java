import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1991 {
    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }
            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    private static void preOrder(int n) {
        if (n == -1) {
            return;
        }
        System.out.print((char)(n + 'A'));
        preOrder(tree[n][0]);
        preOrder(tree[n][1]);
    }

    private static void inOrder(int n) {
        if (n == -1) {
            return;
        }
        inOrder(tree[n][0]);
        System.out.print((char)(n + 'A'));
        inOrder(tree[n][1]);
    }

    private static void postOrder(int n) {
        if (n == -1) {
            return;
        }
        postOrder(tree[n][0]);
        postOrder(tree[n][1]);
        System.out.print((char)(n + 'A'));
    }
}
