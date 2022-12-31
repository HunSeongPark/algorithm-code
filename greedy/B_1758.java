import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A, Collections.reverseOrder());
        long result = 0;
        for (int i = 0; i < N; i++) {
            int tip = A[i] - i;
            if (tip > 0) {
                result += tip;
            }
        }
        System.out.println(result);
    }
}