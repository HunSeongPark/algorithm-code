import java.util.*;
import java.io.*;

public class B_1072 {

	static long X, Y;
	static int Z;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (int)(Y * 100 / (double)X);
		if (X == Y || Z >= 99) {
			System.out.println(-1);
			return;
		}
		long L = 0;
		long R = X;
		long answer = -1;
		while (L <= R) {
			long mid = (L + R) / 2;
			if (check(mid)) {
				answer = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(answer);
		br.close();
	}

	private static boolean check(long n) {
		return Z != (int)((Y + n) * 100 / (double)(X + n));
	}
}
