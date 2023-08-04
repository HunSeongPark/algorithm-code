import java.util.*;
import java.io.*;

public class B_2342 {

	static final int MAX = Integer.MAX_VALUE;
	static int[][][] DP;
	static int N;
	static ArrayList<Integer> comm = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		comm.add(-1);
		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			comm.add(n);
		}
		N = comm.size() - 1;
		DP = new int[5][5][N + 1];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(DP[i][j], MAX);
			}
		}
		DP[0][0][0] = 0;
		for (int n = 1; n <= N; n++) {
			int command = comm.get(n);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (i == j && (i != 0 || j != 0)) continue;
					if (DP[i][j][n - 1] == MAX) continue;
					// i
					if (command != j) {
						DP[command][j][n] = Math.min(DP[command][j][n], DP[i][j][n - 1] + getPower(i, command));
					}
					// j
					if (command != i) {
						DP[i][command][n] = Math.min(DP[i][command][n], DP[i][j][n - 1] + getPower(j, command));
					}
				}
			}
		}
		int answer = MAX;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j && (i != 0 || j != 0)) continue;
				answer = Math.min(answer, DP[i][j][N]);
			}
		}
		System.out.println(answer);
	}

	private static int getPower(int before, int after) {
		if (before == after) return 1;
		if (before == 0) return 2;
		if (Math.abs(before - after) == 2) return 4;
		return 3;
	}
}
