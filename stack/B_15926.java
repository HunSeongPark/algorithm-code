import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_15926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    answer = Math.max(answer, i - stack.peek());
                } else {
                    stack.add(i);
                }
            }
        }
        System.out.println(answer);
    }
}