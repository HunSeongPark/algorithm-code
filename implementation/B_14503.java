import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7:05
public class B_14503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] moveBack = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int[][] moveFront = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        int i = startX;
        int j = startY;
        while (true) {
            // 1
            if (map[i][j] == 0) {
                map[i][j] = -1;
                answer++;
            }
            // 주변 4칸 청소여부 확인
            boolean isClean = true;
            for (int n = 0; n < 4; n++) {
                int x = i + dx[n];
                int y = j + dy[n];
                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (map[x][y] == 0) {
                    isClean = false;
                    break;
                }
            }
            // 2
            if (isClean) {
                int x = i + moveBack[dir][0];
                int y = j + moveBack[dir][1];
                if (x < 0 || y < 0 || x >= N || y >= M) break;
                if (map[x][y] == 1) break;
                i = x;
                j = y;
            } else {
                // 3
                dir -= 1;
                if (dir < 0) dir = 3;
                int x = i + moveFront[dir][0];
                int y = j + moveFront[dir][1];
                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (map[x][y] == 0) {
                    i = x;
                    j = y;
                }
            }
        }
        System.out.println(answer);
    }
}