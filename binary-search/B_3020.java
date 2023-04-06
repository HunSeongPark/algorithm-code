import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3020 {

    static int N, H;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        A = new int[N / 2];
        B = new int[N / 2];
        int iA = 0;
        int iB = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                A[iA++] = Integer.parseInt(br.readLine());
            } else {
                B[iB++] = Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int h = 1; h <= H; h++) {
            int result = binarySearch(h, A) + binarySearch(H - h + 1, B);
            if (min > result) {
                min = result;
                answer = 1;
            } else if (min == result) {
                answer++;
            }
        }
        System.out.println(min + " " + answer);
    }

    public static int binarySearch(int target, int[] arr) {
        int L = 0;
        int R = N / 2;
        while (L < R) {
            int M = (L + R) / 2;
            if (arr[M] >= target) {
                R = M;
            } else {
                L = M + 1;
            }
        }
        return arr.length - R;
    }
}