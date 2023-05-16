import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_24778 {

    static int[][] original = new int[3][3];
    static HashSet<Node> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, original));
        visited.add(new Node(0, original));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (isEnd(cur.m)) {
                return cur.t;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Node next = new Node(cur.t + 1, copyAndUpdateMap(cur.m, i, j));
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isEnd(int[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static int[][] copyAndUpdateMap(int[][] m, int i, int j) {

        // copy map
        int[][] ret = new int[3][3];
        for (int x = 0; x < 3; x++) ret[x] = m[x].clone();

        // update row
        for (int y = 0; y < 3; y++) {
            ret[i][y] = (ret[i][y] + 1) % 4;
        }

        // update col
        for (int x = 0; x < 3; x++) {
            if (x == i) continue;
            ret[x][j] = (ret[x][j] + 1) % 4;
        }

        return ret;
    }

    public static class Node {
        int t;
        int[][] m;

        public Node(int t, int[][] m) {
            this.t = t;
            this.m = m;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return Arrays.deepEquals(m, n.m);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(m);
        }
    }
}