import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // Fib
        int[] fib = new int[N + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        // Answer
        int answer = 1;
        int n = 0;
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= fib[vip - n - 1];
            n = vip;
        }
        answer *= fib[N - n];
        System.out.println(answer);
    }
}
