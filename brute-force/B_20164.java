import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_20164 {

    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec(N, countOdd(N));
        System.out.println(min + " " + max);
    }

    private static void rec(int n, int count) {
        if (n < 10) {
            max = Math.max(max, count);
            min = Math.min(min, count);
        } else if (n < 100) {
            int n1 = n / 10;
            int n2 = n % 10;
            rec(n1 + n2, count + countOdd(n1 + n2));
        } else {
            String st = String.valueOf(n);
            for (int i = 1; i <= st.length() - 2; i++) {
                for (int j = 1; j <= st.length() - 1 - i; j++) {
                    int n1 = Integer.parseInt(st.substring(0, i));
                    int n2 = Integer.parseInt(st.substring(i, i + j));
                    int n3 = Integer.parseInt(st.substring(i + j));
                    rec(n1 + n2 + n3, count + countOdd(n1 + n2 + n3));
                }
            }
        }
    }

    private static int countOdd(int num) {
        int result = 0;
        while (num > 0) {
            int sub = num % 10;
            if (sub % 2 == 1) result++;
            num /= 10;
        }
        return result;
    }
}