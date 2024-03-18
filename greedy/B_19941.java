import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19941 {

    static String s;
    static int[] arr;
    static int N, K, result = 0;
    static final int H = 0;
    static final int P = 1;
    static final int EAT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        s = br.readLine();
        // 햄버거, 사람 구분지어 저장
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i) == 'H' ? H : P;
        }
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            // 사람이 아니라면 넘어간다.
            if (target != P) continue;
            // 왼쪽 햄버거를 먹었는지 여부 판단
            boolean isEat = false;
            for (int j = i - K; j < i; j++) {
                // 범위 유효성 검사
                if (j < 0) continue;
                // 가장 먼 햄버거인 경우 먹음
                if (arr[j] == H) {
                    arr[j] = EAT;
                    result++;
                    isEat = true;
                    break;
                }
            }
            // 왼쪽에 햄버거가 없다면 오른쪽 탐색
            if (!isEat) {
                for (int j = i + 1; j <= i + K; j++) {
                    if (j >= N) break;
                    // 가장 가까운 햄버거인 경우 먹음
                    if (arr[j] == H) {
                        arr[j] = EAT;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}