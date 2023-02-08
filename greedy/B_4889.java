import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        while (true) {
            String s = br.readLine();
            if (s.startsWith("-")) break;
            Stack<Character> stack = new Stack<>();
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        answer++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }
            System.out.println((t++) + ". " + (answer + stack.size() / 2));
        }
    }
}