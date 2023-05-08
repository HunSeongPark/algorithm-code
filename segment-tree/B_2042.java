import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2042 {

    static int N, M, K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        double treeHeight = Math.ceil(Math.log(N) / Math.log(2)) + 1;
        long nodeCount = Math.round(Math.pow(2, treeHeight));
        tree = new long[Math.toIntExact(nodeCount)];
        init(1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                update(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {
                long sum = sum(1, 1, N, b, (int) c);
                answer.append(sum).append("\n");
            }
        }
        System.out.println(answer);
    }

    public static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        return tree[node] = init(node * 2, start, (start + end) / 2) +
                init(node * 2 + 1, (start + end) / 2 + 1, end);
    }

    public static long sum(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(node * 2, start, (start + end) / 2, left, right) +
                sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            update(node * 2, start, (start + end) / 2, index, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }
}