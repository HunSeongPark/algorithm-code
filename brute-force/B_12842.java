import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12842 {

    public static void main(String[] args) throws IOException {
        int n, s, m;
        int[] A;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        A = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        for (int t = 0; ; t++) {
            for (int i = 1; i <= m; i++) {
                if (t % A[i] == 0) {
                    sum++;
                    if (sum >= n - s) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}