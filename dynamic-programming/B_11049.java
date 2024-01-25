import java.util.*;
import java.io.*;

public class B_11049 {

	static int N;
	static int[] R;
	static int[] C;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		R = new int[N];
		C = new int[N];
		DP = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N - 1; i++) {
			DP[i][i + 1] = R[i] * C[i] * C[i + 1];
		}
		for (int size = 2; size < N; size++) {
			for (int i = 0; i + size < N; i++) {
				int j = i + size;
				DP[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int c = DP[i][k] + DP[k + 1][j] + R[i] * C[k] * C[j];
					DP[i][j] = Math.min(DP[i][j], c);
				}
			}	
		}
		System.out.println(DP[0][N - 1]);
	}
}
