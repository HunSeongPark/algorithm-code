import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_20207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] A = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(A);
        int depth = 1;
        int start = A[0].s;
        int end = A[0].e;
        int[] cnt = new int[366];
        for (int i = start; i <= end; i++) {
            cnt[i]++;
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (i == N) {
                result += (depth * (end - start + 1));
            } else {
                Node node = A[i];
                if (end + 1 < node.s) {
                    result += (depth * (end - start + 1));
                    start = node.s;
                    end = node.e;
                    depth = 1;
                    cnt = new int[366];
                    for (int j = start; j <= end; j++) {
                        cnt[j]++;
                    }
                } else {
                    for (int j = node.s; j <= node.e; j++) {
                        cnt[j]++;
                        depth = Math.max(depth, cnt[j]);
                    }
                    end = Math.max(end, node.e);
                }
            }
        }
        System.out.println(result);
    }

    public static class Node implements Comparable<Node> {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.s == o.s) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
}