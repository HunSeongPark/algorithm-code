import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1327 {

    static int N, K;
    static int[] arr, asc;
    static HashSet<Node> visited = new HashSet<>();
    static Node solve;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        asc = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            asc[i] = arr[i];
        }
        Arrays.sort(asc);
        solve = new Node(asc);
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(arr, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.isEnd()) {
                answer = cur.t;
                break;
            }
            for (int k = 0; k <= N - K; k++) {
                int j = k + K - 1;
                int[] change = cur.change.clone();
                for (int i = k; i < k + K / 2; i++) {
                    int tmp = change[i];
                    change[i] = change[j];
                    change[j--] = tmp;
                }
                Node next = new Node(change, cur.t + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static class Node {
        int[] change;
        int t;

        public Node(int[] change, int t) {
            this.change = change;
            this.t = t;
        }

        public Node(int[] change) {
            this.change = change;
        }

        public boolean isEnd() {
            return this.equals(solve);
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return Arrays.equals(n.change, this.change);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(this.change);
        }
    }
}
