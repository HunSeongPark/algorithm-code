import java.util.*;
import java.io.*;

public class B_5569 {

	static final int MOD = 100000, RIGHT = 0, DOWN = 1;
	static int N, M;
	static int[][][][] DP;

    /**
	 * IDX 3 : RIGHT, DOWN : 현재 위치로 들어온 방향
	 * IDX 4 : 0(이전에서 안 꺾고 들어옴), 1(이전에 꺾어서 들어옴)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		DP = new int[N + 1][M + 1][2][2];
		for (int i = 1; i <= N; i++) {
			DP[i][1][DOWN][0] = 1;
		}
		for (int j = 1; j <= M; j++) {
			DP[1][j][RIGHT][0] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= M; j++) {
				DP[i][j][RIGHT][1] = DP[i][j - 1][DOWN][0] % MOD;
				DP[i][j][DOWN][1] = DP[i - 1][j][RIGHT][0] % MOD;
				DP[i][j][RIGHT][0] = (DP[i][j - 1][RIGHT][1] + DP[i][j - 1][RIGHT][0]) % MOD;
				DP[i][j][DOWN][0] = (DP[i - 1][j][DOWN][0] + DP[i - 1][j][DOWN][1]) % MOD;
			}
		}
		System.out.println((DP[N][M][DOWN][0] + DP[N][M][RIGHT][0] + DP[N][M][DOWN][1] + DP[N][M][RIGHT][1]) % MOD);
		br.close();
	}
}
