import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16435 {

    static int N, L;
    static int[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        h = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        // 높이 낮은 순으로 과일 정렬
        Arrays.sort(h);
        // 가장 낮은 높이의 과일부터 차례로 먹어가며 길이를 늘리자.
        for (int i = 0; i < N; i++) {
            if (L >= h[i]) {
                L++;
            }
        }
        System.out.println(L);
    }
}