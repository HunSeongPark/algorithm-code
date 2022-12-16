import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1343 {

    public static void main(String[] args) throws IOException {
        char[] N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().toCharArray();
        for (int i = 0; i < N.length; i++) {
            int n = 0;
            for (int j = i; j < N.length; j++) {
                if (N[j] == 'X') {
                    n++;
                } else {
                    break;
                }
            }
            if (n % 2 != 0) {
                System.out.println(-1);
                return;
            } else {
                while (n > 0) {
                    if (n - 4 >= 0) {
                        for (int k = 0; k < 4; k++) {
                            N[i++] = 'A';
                            n--;
                        }
                    } else if (n - 2 >= 0) {
                        for (int k = 0; k < 2; k++) {
                            N[i++] = 'B';
                            n--;
                        }
                    }
                }
            }
        }
        for (char c : N) {
            System.out.print(c);
        }
    }
}