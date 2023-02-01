import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 2:32
public class B_2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(s[0]);
        int idx;
        for (idx = 1; idx < N; idx++) {
            if (K == 0) break;
            while (!stack.isEmpty() && stack.peek() < s[idx]) {
                stack.pop();
                K--;
                if (K == 0) break;
            }
            stack.push(s[idx]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < N; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < K; i++) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}