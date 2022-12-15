import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1783 {

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (N == 0 || M == 0) {
            System.out.println(0);
        } else if (N == 1 || M == 1) {
            System.out.println(1);
        } else if (N <= 2) {
            if (M >= 7) {
                System.out.println(4);
            } else {
                System.out.println((M + 1) / 2);
            }
        } else if (M <= 4) {
            System.out.println(M);
        } else if (M == 5) {
            System.out.println(4);
        }else {
            System.out.println(M - 2);
        }
    }
}