import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_16472 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] A = br.readLine().toCharArray();
        int[] count = new int[26];
        if (N == 26) {
            System.out.println(A.length);
            return;
        }
        int start = 0;
        int end;
        int len = 0;
        int max = 0;
        for (end = 0; end < A.length; end++) {
            // 처음 나오는 문자
            if (count[A[end] - 'a'] == 0) {
                len++;
                if (len > N) {
                    max = Math.max(max, end - start);
                    while (true) {
                        count[A[start] - 'a']--;
                        if (count[A[start] - 'a'] == 0) {
                            start++;
                            break;
                        }
                        start++;
                    }
                    len--;
                }
            }
            count[A[end] - 'a']++;
        }
        System.out.println(Math.max(max, end - start));
    }
}