import java.util.Scanner;
import java.util.Stack;

public class B_1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 1;
        for (int i = 0; i < N; i++) {
            int num = A[i];

            if (num >= n) {
                while (A[i] >= n) {
                    stack.push(n++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();
                if (pop > num) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}