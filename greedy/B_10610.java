import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            sum += n;
        }
        if (!s.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        StringBuilder answer = new StringBuilder(String.valueOf(chArr));
        System.out.println(answer.reverse());
    }
}
