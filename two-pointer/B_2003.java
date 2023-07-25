import java.util.*;
import java.io.*;

public class B_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int L = 0;
		int R = 0;
		int sum = 0;
		while (R < N) {
			sum += arr[R++];
			if (sum == M) {
				answer++;
			} else if (sum > M) {
				while (sum > M) {
					sum -= arr[L++];
				}
				if (sum == M) {
					answer++;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
