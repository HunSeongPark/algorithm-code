import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2591 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int[] DP = new int[s.length];
        DP[0] = 1;
        for (int i = 1; i < s.length; i++) {
            int n = Integer.parseInt(s[i - 1] + "" + s[i]);
            if (n <= 34 && s[i - 1] != '0') {
                if (i == 1) DP[i] = 1;
                else DP[i] = DP[i - 2];
            }
            if (s[i] != '0') {
                DP[i] += DP[i - 1];
            }
        }
        System.out.println(DP[s.length - 1]);
    }
}
