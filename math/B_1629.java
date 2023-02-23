import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(pow(A, B, C));
    }

    public static long pow(int A, int B, int C) {
        if (B == 1) return A % C;
        long x = pow(A, B / 2, C) % C;
        if (B % 2 == 0) {
            return x % C * x % C;
        } else {
            return x % C * x % C * A % C;
        }
    }
}