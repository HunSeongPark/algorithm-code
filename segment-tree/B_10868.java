import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10868 {

    static int N, M, offset;
    static int[] tree;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (offset = 1; offset < N; offset *= 2);
        tree = new int[offset * 2 + 2];
        for (int i = 0; i < N; i++) {
            tree[i + offset] = Integer.parseInt(br.readLine());
        }
        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            answer.append(min(a, b)).append("\n");
        }
        System.out.println(answer);
    }

    private static int min(int start, int end) {
        start += offset;
        end += offset;
        int ret = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) ret = Math.min(ret, tree[start++]);
            if (end % 2 == 0) ret = Math.min(ret, tree[end--]);
            start /= 2;
            end /= 2;
        }
        return ret;
    }
}
