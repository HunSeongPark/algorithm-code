import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1577 {

    static int N, M, K;
    static HashSet<Node> remove = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            remove.add(new Node(new int[]{x1, y1, x2, y2}));
        }
        long[][] DP = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            if (remove.contains(new Node(new int[]{i - 1, 0, i, 0})) || remove.contains(new Node(new int[]{i, 0, i - 1, 0}))) break;
            DP[i][0] = 1;
        }
        for (int j = 1; j <= M; j++) {
            if (remove.contains(new Node(new int[]{0, j - 1 , 0, j})) || remove.contains(new Node(new int[]{0, j, 0, j - 1}))) break;
            DP[0][j] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!remove.contains(new Node(new int[]{i - 1, j, i, j})) && !remove.contains(new Node(new int[]{i, j, i - 1, j}))) {
                    DP[i][j] += DP[i - 1][j];
                }
                if (!remove.contains(new Node(new int[]{i, j - 1, i, j})) && !remove.contains(new Node(new int[]{i, j, i, j - 1}))) {
                    DP[i][j] += DP[i][j - 1];
                }
            }
        }
        System.out.println(DP[N][M]);
    }

    public static class Node {
        int[] root;

        public Node(int[] root) {
            this.root = root;
        }

        @Override
        public boolean equals(Object o) {
            Node n = (Node) o;
            return Arrays.equals(n.root, this.root);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(root);
        }
    }
}
