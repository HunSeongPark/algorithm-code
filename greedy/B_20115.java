import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20115 {

    public static void main(String[] args) throws IOException {
        int N;
        int[] A;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] > max) {
                max = A[i];
            }
        }
        double result = max;
        for (int i = 0; i < N; i++) {
            if (A[i] != max) {
                result += A[i] / 2.0;
            }
        }
        System.out.println(result);
    }
}