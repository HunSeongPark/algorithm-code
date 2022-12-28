import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
        }
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int min = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;
        while (i < j) {
            int sum = A[i] + A[j];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                n1 = A[i];
                n2 = A[j];
            }
            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(n1 + " " + n2);
    }
}