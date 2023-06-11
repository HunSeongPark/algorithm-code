import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] comm = br.readLine().split(" ");
            if (comm[0].equals("push")) {
                int n = Integer.parseInt(comm[1]);
                stack.push(n);
            }
            if (comm[0].equals("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
            if (comm[0].equals("size")) {
                System.out.println(stack.size());
            }
            if (comm[0].equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
            if (comm[0].equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }
        }
    }
}
