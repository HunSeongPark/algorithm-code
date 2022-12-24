import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13251 {

    public static void main(String[] args) throws IOException {
        int M, N = 0, K;
        int[] rock;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());
        rock = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
            N += rock[i];
        }
        K = Integer.parseInt(br.readLine());
        double result = 0;
        for (int i = 0; i < M; i++) {
            double sum = 1;
            for (int j = 0; j < K; j++) {
                sum *= (double) (rock[i] - j) / (N - j);
            }
            result += sum;
        }
        System.out.println(result);
    }
}
