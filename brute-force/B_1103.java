import java.util.*;
import java.io.*;

public class B_1103 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map, dp;
	static int N, M;
	static int max = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == 'H') {
					map[i][j] = -1;
				} else {
					map[i][j] = c - '0';
				}
			}
		}
		dp[0][0] = 1;
		visited[0][0] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		br.close();
	}
	
	private static void dfs(int i, int j, int w) {
		for (int n = 0; n < 4; n++) {
			int x = i + dx[n] * map[i][j];
			int y = j + dy[n] * map[i][j];
			if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == -1) {
				max = Math.max(max, w);
				continue;
			}
			if (visited[x][y]) {
				System.out.println(-1);
				System.exit(0);
			}
			if (dp[x][y] >= w + 1) continue;
			dp[x][y] = w + 1;
			visited[x][y] = true;
			dfs(x, y, w + 1);
			visited[x][y] = false;
		}
	}

}
