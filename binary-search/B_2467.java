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
        int min = Integer.MAX_VALUE;
        int answerL = 0;
        int answerR = 0;
        for (int i = 0; i < N - 1; i++) {
            int target = arr[i] * -1;
            int find = binarySearch(i + 1, N - 1, target, arr);
            if (Math.abs(arr[i] + find) < min) {
                min = Math.abs(arr[i] + find);
                answerL = Math.min(arr[i], find);
                answerR = Math.max(arr[i], find);
            }
        }
        System.out.println(answerL + " " + answerR);
    }

    public static int binarySearch(int L, int R, int target, int[] arr) {
        int min = Integer.MAX_VALUE;
        int answer = 0;
        while (L <= R) {
            int M = (L + R) / 2;
            if (Math.abs(target - arr[M]) < min) {
                min = Math.abs(target - arr[M]);
                answer = arr[M];
            }
            if (target < arr[M]) {
                R = M - 1;
            } else if (target > arr[M]) {
                L = M + 1;
            } else {
                return answer;
            }
        }
        return answer;
    }
}