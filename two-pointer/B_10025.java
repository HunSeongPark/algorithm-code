import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[100_0001];
        int xEnd = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            A[x] = g;
            xEnd = Math.max(xEnd, x);
        }
        int start = 0;
        int end = K * 2;
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (i > xEnd) {
                System.out.println(max);
                return;
            }
            max += A[i];
        }
        int cur = max;
        while (end <= xEnd) {
            cur -= A[start++];
            cur += A[++end];
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}