import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            A[i] = s.charAt(i) - '0';
        }
        s = br.readLine();
        for (int i = 0; i < N; i++) {
            B[i] = s.charAt(i) - '0';
        }
        int[] C = A.clone();
        int[] D = A.clone();
        int cur1 = 1;
        int cur2 = 0;
        C[0] = (C[0] + 1) % 2;
        C[1] = (C[1] + 1) % 2;
        for (int i = 1; i < N; i++) {
            if (C[i - 1] != B[i - 1]) {
                cur1++;
                C[i - 1] = (C[i - 1] + 1) % 2;
                C[i] = (C[i] + 1) % 2;
                if (i + 1 < N) {
                    C[i + 1] = (C[i + 1] + 1) % 2;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            if (D[i - 1] != B[i - 1]) {
                cur2++;
                D[i - 1] = (D[i - 1] + 1) % 2;
                D[i] = (D[i] + 1) % 2;
                if (i + 1 < N) {
                    D[i + 1] = (D[i + 1] + 1) % 2;
                }
            }
        }
        if (!check(C, B, N)) {
            cur1 = Integer.MAX_VALUE;
        }
        if (!check(D, B, N)) {
            cur2 = Integer.MAX_VALUE;
        }
        int result = Math.min(cur1, cur2);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static boolean check(int[] A, int[] B, int N) {
        for (int i = 0; i < N; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}