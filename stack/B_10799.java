import java.util.Scanner;
import java.util.Stack;

public class B_10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 여는괄호
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                // 레이저
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    // 파이프의 끝
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}