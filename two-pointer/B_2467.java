import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2467
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int L = 0;
        int R = N - 1;
        int answerL = 0;
        int answerR = 0;
        int min = Integer.MAX_VALUE;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerL = arr[L];
                answerR = arr[R];
            }
            if (sum == 0) {
                break;
            } else if (sum > 0) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(answerL + " " + answerR);
    }
}