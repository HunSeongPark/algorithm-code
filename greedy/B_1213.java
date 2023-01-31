import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] A = new int[26];
        for (int i = 0; i < s.length(); i++) {
            A[s.charAt(i) - 'A']++;
        }
        int oddCount = 0;
        for (int n : A) {
            if (n % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < A[i] / 2; j++) {
                a.append((char) (i + 'A'));
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            b.append(a.charAt(i));
        }
        for (int i = 0; i < 26; i++) {
            if (A[i] % 2 != 0) {
                a.append((char) (i + 'A'));
            }
        }
        System.out.println(a.append(b));
    }
}