import java.io.*;
import java.util.Stack;

public class B_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] T = new int[N + 1];
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = Integer.parseInt(str[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}