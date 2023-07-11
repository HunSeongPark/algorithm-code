import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            boolean isFind = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    isFind = false;
                    break;
                }
            }
            answer.append(isFind ? "yes" : "no").append("\n");
        }
        System.out.println(answer);
    }
}
