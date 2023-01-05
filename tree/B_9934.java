import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_9934 {

    static int K;
    static int[] A;
    static ArrayList<Integer>[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[(int)Math.pow(2, K) - 1];
        for (int i = 0; i < (int) Math.pow(2, K) - 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            result[i] = new ArrayList<>();
        }
        inorder(0, A.length - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (Integer n : result[i]) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void inorder(int start, int end, int depth) {
        int mid = (start + end) / 2;
        result[depth].add(A[mid]);
        if (depth == K - 1) return;
        inorder(start, mid - 1, depth + 1);
        inorder(mid + 1, end , depth + 1);
    }
}