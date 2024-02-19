import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_2776_bs {

    static int[] note;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            note = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(num) ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int target) {
        // 최초 시작 - 끝 설정
        int L = 0;
        int R = N - 1;
        while (L <= R) {
            // 중간값
            int mid = (L + R) / 2;
            // 일치 시 true
            if (note[mid] == target) {
                return true;
            } else if (note[mid] > target) {
                // mid 값이 더 클 경우 mid 기준 앞의 배열 덩어리로 재시도
                R = mid - 1;
            } else {
                // mid 값이 더 작을 경우 mid 기준 뒤의 배열 덩어리로 재시도
                L = mid + 1;
            }
        }
        return false;
    }
}