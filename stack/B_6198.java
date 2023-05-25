import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(num);
        }
        System.out.println(answer);
    }
}
