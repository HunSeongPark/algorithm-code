import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            boolean isBreak = false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println("no");
                        isBreak = true;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println("no");
                        isBreak = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!isBreak) {
                if (!stack.isEmpty()) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
        }
    }
}