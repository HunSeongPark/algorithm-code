import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2716 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int depth = 0;
            int max = 0;
            char[] A = br.readLine().toCharArray();
            for (char c : A) {
                if (c == '[') {
                    depth++;
                    if (depth > max) {
                        max = depth;
                    }
                } else {
                    depth--;
                }
            }
            System.out.println((int) Math.pow(2, max));
        }
    }
}