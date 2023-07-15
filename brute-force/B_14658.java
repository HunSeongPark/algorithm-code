import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14658 {

    static int N, M, L, K;
    static int[][] stars;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new int[]{x, y};
        }
        for (int[] A : stars) {
            for (int[] B : stars) {
                int x = A[0];
                int y = B[1];
                answer = Math.max(answer, check(x, y));
            }
        }
        System.out.println(K - answer);
    }

    public static int check(int x, int y) {
        int count = 0;
        for (int[] star : stars) {
            int dx = star[0];
            int dy = star[1];
            if (x <= dx && dx <= x + L & y <= dy && dy <= y + L) count++;
        }
        return count;
    }
}