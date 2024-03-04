import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11060 {

    static int[] DP, map;
    static int N;
    static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N];
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 방문하지 않은 미로 최댓값 초기화
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            DP[i] = MAX;
        }
        // 처음 위치는 0으로 초기화
        DP[0] = 0;
        for (int i = 0; i < N; i++) {
            // 현재 위치의 값이 MAX일 경우 이동 불가능 한 위치이므로 continue
            if (DP[i] == MAX) continue;
            int num = map[i];
            // 현재 위치에서 이동 가능한 미로 순회하며 최소 이동횟수 업데이트
            for (int j = i + 1; j <= i + num; j++) {
                // map을 넘어갈 시 break
                if (j >= N) break;
                // 이동 가능한 미로의 최소 이동횟수 업데이트
                DP[j] = Math.min(DP[j], DP[i] + 1);
            }
        }
        System.out.println(DP[N - 1] == MAX ? -1 : DP[N - 1]);
    }
}