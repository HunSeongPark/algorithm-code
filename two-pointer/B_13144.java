import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] count = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && count[A[end]] == 0) {
                count[A[end]]++;
                end++;
            }
            result += end - start;
            count[A[start]]--;
        }
        System.out.println(result);
    }
}