import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2583 {

    static int M, N, K, cur;
    static int[] dx = {-1, 0, 1, 0}; // 상하좌우
    static int[] dy = {0, -1, 0, 1}; // 상하좌우
    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1; // 직사각형 위치 1로 마킹 (visited)
                }
            }
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 0) { // 마킹 안된 영역부터 dfs 수행
                    cur = 0;
                    dfs(x, y);
                    result.add(cur); // 결과 저장
                }
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(result.size())).append("\n"); // 결과 size 출력
        result.stream().sorted().forEach(n -> sb.append(n).append(" ")); // stream 만들고 sorted로 오름차순 정렬 후 forEach를 통해 출력
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        cur++; // 방문했으니 현재 영역 크기 +1
        map[x][y] = 1; // 방문처리
        for (int n = 0; n < 4; n++) { // 상하좌우 방문
            int nx = x + dx[n];
            int ny = y + dy[n];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) continue; // 맵 벗어남 or 이미 방문한 경우 스킵
            dfs(nx, ny); // dfs 재귀
        }
    }
}