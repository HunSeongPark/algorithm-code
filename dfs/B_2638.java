import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2638 {

    static int N, M, cheese = 0, time = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        // map
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1; // 임의로 치즈는 -1로 설정 (time에서 1 사용 예정)
                    cheese++;
                }
            }
        }

        // 치즈가 모두 녹을때까지 반복
        while (cheese > 0) {
            time++;
            marking(time, 0, 0); // 0,0부터 외부공기 time으로 마킹
            meltCheese(); // 치즈 녹이러 출발
        }
        System.out.println(time);
    }

    public static void marking(int time, int x, int y) {
        map[x][y] = time; // 외부공기 마킹
        for (int n = 0; n < 4; n++) {
            int nx = x + dx[n];
            int ny = y + dy[n];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 맵 벗어나는 경우 스킵
            if (map[nx][ny] == time || map[nx][ny] == -1) continue; // 이미 방문 or 치즈인 경우 스킵
            marking(time, nx, ny); // 외부공기 마킹하러 이동
        }
    }

    public static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) continue; // 치즈 아닌경우 스킵
                int airCount = 0; // 현재 치즈에 닿은 외부공기 count
                for (int n = 0; n < 4; n++) {
                    int nx = i + dx[n];
                    int ny = j + dy[n];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 맵 벗어나는 경우 스킵
                    if (map[nx][ny] > 0) airCount++; // 외부공기 카운트 (0 == 외부공기 X / -1 == 치즈 / > 0 == 외부공기)
                }
                // 외부공기 2칸 이상 닿은 경우
                if (airCount >= 2) {
                    cheese--; // 치즈 녹음
                    map[i][j] = 0; // 외부공기 닿지 않은 빈칸 처리
                }
            }
        }
    }
}
