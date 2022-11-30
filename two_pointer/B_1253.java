import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Hunseong-Park
 * @date : 2022-11-30
 */
public class B_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        Arrays.sort(A);
        int count = 0;
        for (int n = 0; n < N; n++) {
            long K = A[n];
            int i = 0;
            int j = N - 1;
            while (i < j) {
                if (A[i] + A[j] > K) {
                    j--;
                } else if (A[i] + A[j] < K) {
                    i++;
                } else {
                    if (i != n && j != n) {
                        count++;
                        break;
                    } else if (i == n) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}