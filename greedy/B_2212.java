import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] arr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for (int i = 0; i < N - 1; i++) {
            arr[i] = A[i + 1] - A[i];
        }
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}