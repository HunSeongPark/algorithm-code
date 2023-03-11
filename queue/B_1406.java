import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_1406 {

    static int N, M;
    static String str;
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            left.addLast(str.charAt(i));
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "P":
                    char ch = st.nextToken().charAt(0);
                    left.addLast(ch);
                    break;
                case "L":
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                default:
                    if (!left.isEmpty()) left.pollLast();
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }
        System.out.println(sb);
    }
}