import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char prev = s[0];
        int count0 = s[0] == '0' ? 1 : 0;
        int count1 = s[0] == '1' ? 1 : 0;

        for (int i = 1; i < s.length; i++) {
            if (prev != s[i]) {
                prev = s[i];
                if (s[i] == '0') count0++;
                else count1++;
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}