import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fib = new long[21];
        boolean[] selected = new boolean[21];
        Arrays.fill(fib, 1);
        for (int i = 1; i <= 20; i++) {
            fib[i] = fib[i - 1] * i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int problem = Integer.parseInt(st.nextToken());
        if (problem == 1) {
            long k = Long.parseLong(st.nextToken());
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                   if (selected[j]) continue;
                    if (fib[N - 1 - i] < k) {
                        k -= fib[N - 1 - i];
                    } else {
                        answer.append(j).append(" ");
                        selected[j] = true;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }

        if (problem == 2) {
            long answer = 1;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                int cur = arr[i];
                for (int j = 1; j < cur; j++) {
                    if (!selected[j]) {
                        answer += fib[N - 1 - i];
                    }
                }
                selected[cur] = true;
            }
            System.out.println(answer);
        }

    }
}