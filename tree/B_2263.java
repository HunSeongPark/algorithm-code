import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2263 {

    static int N;
    static int[] in;
    static int[] post;
    static int[] pre;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        in = new int[N];
        post = new int[N];
        pre = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        preOrder(0, N - 1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : pre) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    private static void preOrder(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end) {
            return;
        }

        pre[idx++] = post[post_end];

        int pos = in_start;
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == post[post_end]) {
                pos = i;
                break;
            }
        }
        preOrder(in_start, pos - 1, post_start, post_start + pos - in_start - 1);
        preOrder(pos + 1, in_end, post_start + pos - in_start, post_end - 1);
    }
}