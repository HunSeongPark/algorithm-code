import java.io.*;
import java.util.*;

public class B_11663 {

    static int N, M;
    static int[] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        // 점 기준 이분탐색을 위해 오름차순 정렬
        Arrays.sort(dots);
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 선분 시작점, 끝점을 target으로 이분탐색
            result.append(binarySearch(start, end)).append("\n");
        }
        System.out.println(result);
    }

    private static int binarySearch(int start, int end) {
        // end >= dot인 last index 구하기
        int L = 0;
        int R = N - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (dots[M] > end) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        int endIdx = R;
        // start > dot인 last index 구하기
        L = 0;
        R = N - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (dots[M] >= start) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        int startIdx = R;
        // 0 ~ 끝점인 점의 개수 - 시작점보다 이전인 점의 개수 = 선분 위의 점의 개수
        return endIdx - startIdx;
    }
}