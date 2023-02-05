import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        int result = 0;
        if (s1.length() != s2.length()) {
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == c2 && c1 == '8') {
                    result++;
                } else if (c1 != c2) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}