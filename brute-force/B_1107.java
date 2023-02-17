import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1107 {

    static int min = Integer.MAX_VALUE;
    static int N;
    static int M;
    static boolean[] button;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        button = new boolean[10];
        StringTokenizer st = null;
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            button[n] = true;
        }
        if (M == 100) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean isOk = true;
            for (int j = 0; j < s.length(); j++) {
                int n = s.charAt(j) - '0';
                if (button[n]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                min = Math.min(min, Math.abs(N - i) + s.length());
            }
        }
        System.out.println(Math.min(min, Math.abs(100 - N)));
    }
}