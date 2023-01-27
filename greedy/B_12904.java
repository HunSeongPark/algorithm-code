import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();
        for (int i = T.length - 1; i >= S.length; i--) {
            if (T[i] == 'B') {
                for (int j = 0; j < i / 2; j++) {
                    char tmp = T[j];
                    T[j] = T[i - j - 1];
                    T[i - j - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < S.length; i++) {
            if (S[i] != T[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}