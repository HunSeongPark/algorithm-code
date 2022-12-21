import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1614 {

    public static void main(String[] args) throws IOException {
        long N, cnt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        cnt = Long.parseLong(br.readLine());
        if (N == 1) {
            if (cnt == 0) {
                System.out.println(0);
            } else {
                System.out.println(8 * cnt);
            }
        } else if (N == 5) {
            if (cnt == 0) {
                System.out.println(4);
            } else {
                System.out.println(8 * cnt + 4);
            }
        } else {
            long left = (N - 1) * 2  - 1;
            long right = (5 - N) * 2 - 1;
            // 짝수
            if (cnt % 2 == 0) {
                long repeat = cnt / 2;
                System.out.println(((repeat + 1) * left - (N - 2)) + repeat * right + cnt);
            } else {
                // 홀수
                long repeat = (cnt + 1) / 2;
                if (repeat == 0) {
                    System.out.println(N - 1);
                } else {
                    System.out.println((repeat * left - (N - 2)) + repeat * right + cnt);
                }
            }
        }
    }
}
