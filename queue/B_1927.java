import java.util.*;
import java.io.*;

public class B_1927 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (pq.isEmpty()) {
					answer.append(0).append("\n");
				} else {
					answer.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(n);
			}
		}
		System.out.print(answer);
		br.close();
	}
}
