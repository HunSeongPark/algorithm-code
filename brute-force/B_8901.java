import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_8901 {

    static int A;
    static int B;
    static int C;
    static int AB;
    static int BC;
    static int CA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            AB = Integer.parseInt(st.nextToken());
            BC = Integer.parseInt(st.nextToken());
            CA = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int i = 0; i <= A && i <= B; i++) {
                int sum = AB * i;
                int a = A - i;
                int b = B - i;
                int c = C;
                if (BC >= CA) {
                    if (b >= c) {
                        sum += (c * BC);
                        c = 0;
                    } else {
                        sum += (b * BC);
                        c -= b;
                    }
                    if (a >= c) {
                        sum += (c * CA);
                    } else {
                        sum += (a * CA);
                    }
                } else {
                    if (a >= c) {
                        sum += (c * CA);
                        c = 0;
                    } else {
                        sum += (a * CA);
                        c -= a;
                    }
                    if (b >= c) {
                        sum += (c * BC);
                    } else {
                        sum += (b * BC);
                    }
                }
                if (sum > max) {
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}