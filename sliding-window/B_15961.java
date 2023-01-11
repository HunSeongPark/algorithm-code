import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] count = new int[d + 1];
        int max = 0;
        int cur = 0;
        boolean isCoupon = false;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            count[A[i]]++;
            if (count[A[i]] == 1) max++;
        }
        if (count[c] == 0) {
            isCoupon = true;
            max++;
        }
        int start = 0;
        int end = k - 1;
        cur = max;
        while (start < N - 1) {
            count[A[start]]--;
            if (count[A[start]] == 0) {
                cur--;
            }
            start++;
            end = (end + 1) % N;
            count[A[end]]++;
            if (count[A[end]] == 1) {
                cur++;
            }
            if (count[c] == 0 && !isCoupon) {
                cur++;
                isCoupon = true;
            }
            if (count[c] > 0 && isCoupon) {
                cur--;
                isCoupon = false;
            }
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}