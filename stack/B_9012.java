import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            boolean isNo = false;
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        isNo = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (isNo || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
