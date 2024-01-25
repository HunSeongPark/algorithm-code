import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] gcdL = new int[N + 2];
        int[] gcdR = new int[N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            gcdL[i] = gcd(gcdL[i - 1], arr[i]);
        }
        for (int i = N; i >= 1; i--) {
            gcdR[i] = gcd(gcdR[i + 1], arr[i]);
        }
        int max = -1;
        int K = -1;
        for (int i = 1; i <= N; i++) {
            int result = gcd(gcdL[i - 1], gcdR[i + 1]);
            if (arr[i] % result != 0 && result > max) {
                max = result;
                K = arr[i];
            }
        }
        System.out.print(max);
        if (K != -1) System.out.print(" " + K);
    }

    private static int gcd(int a, int b) {
        int c;
        while (b > 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
