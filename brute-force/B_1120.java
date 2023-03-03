import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int answer = Integer.MAX_VALUE;

        if (str1.length() == str2.length()) {
            System.out.println(check(str1, str2));
            return;
        }
        int diff = str2.length() - str1.length();
        for (int front = 0; front <= diff; front++) {
            int back = diff - front;
            String newStr = str2.substring(0, front) + str1 + str2.substring(front + str1.length(), front + str1.length() + back);
            answer = Math.min(answer, check(newStr, str2));
        }
        System.out.println(answer);
    }

    public static int check(String str1, String str2) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) result++;
        }
        return result;
    }
}