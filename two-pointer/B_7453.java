import java.util.*;
import java.io.*;

public class B_7453 {

	static int N;
	static int[] A, B, C, D, ab, cd;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		ab = new int[N * N];
		cd = new int[N * N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		int abIdx = 0;
		int cdIdx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[abIdx++] = A[i] + B[j];
				cd[cdIdx++] = C[i] + D[j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		abIdx = 0;
		cdIdx = N * N - 1;
		long answer = 0;
		while (abIdx < N * N && cdIdx >= 0) {
			int sum = ab[abIdx] + cd[cdIdx];
			if (sum > 0) {
				cdIdx--;
			} else if (sum < 0) {
				abIdx++;
			} else {
				int abCnt = 1;
				int cdCnt = 1;
				while (cdIdx > 0 && cd[cdIdx] == cd[cdIdx - 1]) {
					cdCnt++;
					cdIdx--;
				}
				cdIdx--;
				while (abIdx < N * N - 1 && ab[abIdx] == ab[abIdx + 1]) {
					abCnt++;
					abIdx++;
				}
				abIdx++;
				answer += (long)abCnt * cdCnt;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
