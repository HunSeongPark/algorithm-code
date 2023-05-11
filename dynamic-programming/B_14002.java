import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[N];
        int[] DP = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 1;
        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) DP[i] = Math.max(DP[i], DP[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[i]);
        }
        answer.append(max).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (DP[i] == max) {
                stack.push(arr[i]);
                max--;
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append(" ");
        }
        System.out.println(answer);
    }
}
