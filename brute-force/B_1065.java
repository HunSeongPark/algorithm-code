import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 100) {
            System.out.println(N);
            return;
        }
        int answer = 99;
        for (int n = 100; n <= N; n++) {
            int first = n / 100;
            int second = (n % 100) / 10;
            int third = n % 10;
            if (first - second == second - third) answer++;
        }
        System.out.println(answer);
    }
}