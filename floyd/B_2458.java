import java.util.*;
import java.io.*;

public class B_2458 {

	static boolean[][] distance;
	static int N, M, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new boolean[N + 1][N + 1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			distance[a][b] = true;
		}
		floyd();
		calcCount();
		System.out.println(answer);
	}
	
	private static void calcCount() {
		int[] count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distance[i][j]) {
					count[i]++;
					count[j]++;
					if (count[i] == N - 1) answer++;
					if (count[j] == N - 1) answer++;
				}
			}
		}
	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					if (distance[i][j]) continue;
					if (distance[i][k] && distance[k][j]) {
						distance[i][j] = true;
					}
				}
			}
		}
	}
}
