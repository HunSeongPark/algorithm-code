import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15927 {

    public static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        // 문자열의 모든 문자가 같은지
        boolean isAllSame = true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            // 각 위치의 L, R 문자 비교.
            // 다르다면 문자열 자체는 팰린드롬이 아니므로 len이 정답
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                System.out.println(len);
                return;
            }
            // 현재 문자와 다음 문자가 다르다면 문자열의 모든 문자가 같지 않음
            if (s.charAt(i) != s.charAt(i + 1)) {
                isAllSame = false;
            }
        }
        // 모든 문자열의 문자가 같다면 모든 부분 문자열은 팰린드롬
        if (isAllSame) {
            System.out.println(-1);
        } else {
            // 문자열 자체는 팰린드롬 && 문자가 다르다면 문자 하나를 제외한 문자열은 팰린드롬. len - 1
            System.out.println(len - 1);
        }
    }
}