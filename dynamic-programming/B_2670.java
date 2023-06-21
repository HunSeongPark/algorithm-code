import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double[] DP = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        DP[0] = arr[0];
        for (int i = 1; i < N; i++) {
            DP[i] = Math.max(arr[i], DP[i - 1] * arr[i]);
        }
        double answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, DP[i]);
        }
        System.out.printf("%.3f%n", answer);
    }
}