import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.startsWith("0")) {
            System.out.println(0);
            return;
        }
        long[] DP = new long[s.length() + 1];
        DP[0] = DP[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if (cur == '0') {
                if (prev != '1' && prev != '2') {
                    System.out.println(0);
                    return;
                } else {
                    DP[i] = DP[i - 2] % 1000000;
                }
            } else {
                int num = (prev - '0') * 10 + (cur - '0');
                if (num >= 0 && num <= 26 && prev != '0') {
                    DP[i] = DP[i - 1] % 1000000 + DP[i - 2] % 1000000;
                } else {
                    DP[i] = DP[i - 1] % 1000000;
                }
            }
        }
        System.out.println(DP[s.length()] % 1000000);
    }
}