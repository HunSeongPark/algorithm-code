import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11509 {

    private static int N, result = 0;
    // 풍선 높이는 최대 100만
    private static int[] arr = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 현재 위치의 풍선 높이 H
            int H = Integer.parseInt(st.nextToken());
            // 현재 높이에 화살이 남아있다면
            if (arr[H] > 0) {
                // 화살 사용
                arr[H]--;
            }
            // 현재 높이에 화살이 남아있어서 그 화살을 썼든, 화살이 없어 새 화살을 쐈든 H - 1 높이에는 화살이 하나 생긴다.
            arr[H - 1]++;
        }

        // 각 높이에 남아있는 화살 수의 합을 구한다. (쏜 화살 수)
        for (int i : arr) {
            result += i;
        }
        System.out.println(result);
    }
}
