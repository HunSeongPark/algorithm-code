import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] count = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < N) {
            while (end < N && count[A[end]] < K) {
                count[A[end]]++;
                end++;
            }
            max = Math.max(max, end - start);
            count[A[start]]--;
            start++;
        }
        System.out.println(max);
    }
}