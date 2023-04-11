import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char prev = S.charAt(0);
        int O = 0;
        int I = prev == 'I' ? 1 : 0;
        int answer = 0;
        for (int i = 1; i < M; i++) {
            char cur = S.charAt(i);
            if (cur == prev) {
                if (cur == 'O') O--;
                int cnt = ((O + I) - (N * 2 + 1)) / 2 + 1;
                if (cnt > 0 && I >= N + 1 && O >= N) answer += cnt;
                O = 0;
                I = cur == 'I' ? 1 : 0;
            } else if (cur == 'O' && I > 0) {
                O++;
            } else if (cur == 'I') {
                I++;
            }
            prev = cur;
        }
        int cnt = ((O + I) - (N * 2 + 1)) / 2 + 1;
        if (cnt > 0 && I >= N + 1 && O >= N) answer += cnt;
        System.out.println(answer);
    }
}