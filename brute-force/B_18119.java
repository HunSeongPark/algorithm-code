import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18119 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int alp = (1 << 27) - 1;
        int[] words = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                words[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int target = st.nextToken().charAt(0) - 'a';
            if (op == 1) {
                alp &= ~(1 << target);
            } else {
                alp |= (1 << target);
            }
            int count = 0;
            for (int word : words) {
                if ((alp & word) == word) count++;
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }
}
