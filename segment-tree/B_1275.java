import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1275 {

    static int N, Q;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        IndexedTree tree = new IndexedTree();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            answer.append(tree.sum(x, y)).append("\n");
            tree.update(a, b);
        }
        System.out.println(answer);
    }

    private static class IndexedTree {
        private long[] tree;
        private int offset;

        public IndexedTree() {
            for (offset = 1; offset < N; offset *= 2);
            tree = new long[offset * 2 + 2];
            for (int i = 0; i < N; i++) {
                tree[i + offset] = arr[i];
            }
            for (int i = offset - 1; i >= 1; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        private void update(int idx, int value) {
            idx += offset;
            tree[idx] = value;
            while (idx > 0) {
                idx /= 2;
                tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            }
        }

        private long sum(int start, int end) {
            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }
            long result = 0;
            start += offset;
            end += offset;
            while (start <= end) {
                if (start % 2 == 1) result += tree[start++];
                if (end % 2 == 0) result += tree[end--];
                start /= 2;
                end /= 2;
            }
            return result;
        }
    }
}
