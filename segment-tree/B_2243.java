import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SegmentTree tree = new SegmentTree();
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 2) {
                int C = Integer.parseInt(st.nextToken());
                tree.update(1, 1, 1_000_000, B, C);
            } else {
                int result = binarySearch(tree, B);
                answer.append(result).append("\n");
                tree.update(1, 1, 1_000_000, result, -1);
            }
        }
        System.out.println(answer);
    }

    public static int binarySearch(SegmentTree tree, int target) {
        int S = 1;
        int E = 1_000_000;
        int ret = 0;
        while (S <= E) {
            int M = (S + E) / 2;
            long sum = tree.sum(1, 1, 1_000_000, 1, M);
            if (sum < target) {
                S = M + 1;
            } else {
                ret = M;
                E = M - 1;
            }
        }
        return ret;
    }

    public static class SegmentTree {
        long[] tree;

        public SegmentTree() {
            double treeHeight = Math.ceil(Math.log(1_000_000) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        public void update(int node, int start, int end, int idx, int diff) {
            if (idx < start || end < idx) {
                return;
            }
            tree[node] += diff;

            if (start == end) return;

            int mid = (start + end) / 2;

            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
        }
    }
}
