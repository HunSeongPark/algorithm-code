import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2012 {

    static int N;
    static int[] arr;
    static long result = 0; // 최대 0..499,999 더한 값이므로 long!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 예상 등수 오름차순 정렬
        for (int i = 1; i <= N; i++) { // 예상 등수가 높은 순부터 실제 등수를 매김
            int n = arr[i];
            result += Math.abs(i - n); // |A - B|
        }
        System.out.println(result);
    }
}