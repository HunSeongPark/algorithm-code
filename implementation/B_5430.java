import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String op = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String arrStr = br.readLine();
            String[] split = arrStr.substring(1, arrStr.length() - 1).split(",");
            for (int i = 0; i < N; i++) {
                deque.addLast(Integer.parseInt(split[i]));
            }
            boolean isError = false;
            boolean isReverse = false;
            for (int i = 0; i < op.length(); i++) {
                char c = op.charAt(i);
                if (c == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.size() == 0) {
                        System.out.println("error");
                        isError = true;
                        break;
                    } else {
                        if (isReverse) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }
            if (!isError) {
                StringBuilder answer = new StringBuilder();
                answer.append("[");
                while (!deque.isEmpty()) {
                    if (isReverse) {
                        answer.append(deque.pollLast());
                    } else {
                        answer.append(deque.pollFirst());
                    }
                    if (!deque.isEmpty()) {
                        answer.append(",");
                    }
                }
                answer.append("]");
                System.out.println(answer);
            }

        }
    }
}