import java.util.Scanner;

public class B_24499 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        int result = 0;
        int cur = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {
            cur += A[i];
        }
        result = cur;
        for (int j = 0; j < N - 1; j++) {
            int i = (j + K) % N;
            cur += A[i];
            cur -= A[j];
            if (cur > result) result = cur;
        }
        System.out.println(result);
    }
}
