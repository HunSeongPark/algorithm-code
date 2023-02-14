import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        if (M == 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(A);
        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;
        while (j < N) {
            if (A[j] - A[i] == M) {
                answer = M;
                break;
            }
            if (A[j] - A[i] < M) {
                j++;
            } else {
                answer = Math.min(answer, A[j] - A[i]);
                i++;
            }
        }
        System.out.println(answer);
    }
}