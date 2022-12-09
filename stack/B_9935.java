import java.io.*;
import java.util.Stack;

public class B_9935 {

    static String str;
    static String bomb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean match = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != stack.get(stack.size() - bomb.length() + j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (Character c : stack) {
                sb.append(c);
            }
        }
        System.out.println(sb);
        clear();
    }

    private static void input() throws IOException {
        str = br.readLine();
        bomb = br.readLine();
    }

    private static void clear() throws IOException {
        br.close();
    }
}