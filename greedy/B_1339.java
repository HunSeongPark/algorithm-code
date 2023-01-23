import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        int[] num = new int[26];
        for (String str : s) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                num[c - 'A'] += Math.pow(10, str.length() - i - 1);
            }
        }
        Arrays.sort(num);
        int result = 0;
        int cur = 9;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == 0) break;
            result += num[i] * cur--;
        }
        System.out.println(result);
    }
}