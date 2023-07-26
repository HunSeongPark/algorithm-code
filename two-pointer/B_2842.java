import java.util.*;
import java.io.*;

/**
 * 1. 피로도 모두 조사 후 정렬
 * 2. 투포인터로 피로도 제한 L = 0, R = 1 최초 설정
 * 3. min, max 피로도 제한을 기준으로 bfs 수행
 *   3-1. min ~ max 피로도에 대해서만 이동 가능하도록 처리
 *   3-2. bfs 처리하면서 방문한 K 개수 count
 * 4. bfs가 끝났을 때 K == count 확인
 *  4-1. 실패라면 R++을 통해 피로도 제한 늘리고 재시도
 *  4-2. 성공이라면 result min 비교 업데이트 후 L++을 통해 피로도 제한 줄이고 재시도
 *  4-3. R < N * N 까지 반복 
 */
public class B_2842 {
	
	static char[][] map;
	static int[][] P;
	static int[] arr;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int N, K;
	static Node start;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		P = new int[N][N];
		arr = new int[N * N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'K') {
					K++;
				}
				if (map[i][j] == 'P') {
					start = new Node(i, j);
				}
			}
		}
		
		// [1]
		int arrIdx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				P[i][j] = Integer.parseInt(st.nextToken());
				arr[arrIdx++] = P[i][j];
			}
		}
		Arrays.sort(arr);
		
		// [2]
		int L = 0;
		int R = 1;
		while (R < N * N && L < N * N) {
			// [3, 4]
			if (bfs(arr[L], arr[R])) {
				answer = Math.min(answer, arr[R] - arr[L]);
				L++;
			} else {
				R++;
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	private static boolean bfs(int min, int max) {
		int startP = P[start.i][start.j];
		if (startP < min || startP > max) return false;
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(start);
		int count = 0;
		visited[start.i][start.j] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (map[cur.i][cur.j] == 'K') {
				count++;
				if (K == count) break;
			}
			for (int n = 0; n < 8; n++) {
				int x = cur.i + dx[n];
				int y = cur.j + dy[n];
				if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) continue;
				int curP = P[x][y];
				if (curP < min || curP > max) continue;
				visited[x][y] = true;
				queue.add(new Node(x, y));
			}
		}
		if (K == count) {
			return true;
		}
		return false;
	}

	private static class Node {
		int i;
		int j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
