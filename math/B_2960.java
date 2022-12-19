import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2960 {

    public static void main(String[] args) throws IOException {
        int N, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] A = new boolean[N + 1];
        int count = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if (!A[j]) {
                    A[j] = true;
                    count++;
                }
                if (count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
        br.close();
    }
}