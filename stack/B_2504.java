import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int mul = 1;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                mul *= 2;
                stack.push('(');
            } else if (s.charAt(i) == '[') {
                mul *= 3;
                stack.push('[');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    answer += mul;
                }
                mul /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (s.charAt(i - 1) == '[') {
                    answer += mul;
                }
                mul /= 3;
            }
        }
        System.out.println(stack.isEmpty() ? answer : 0);
    }
}