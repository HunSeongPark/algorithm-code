import java.util.*;
import java.io.*;

public class B_1655 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (i % 2 == 1) {
				if (!pq2.isEmpty() && pq2.peek() < n) {
					pq1.add(pq2.poll());
					pq2.add(n);
				} else {
					pq1.add(n);
				}
			} else {
				if (!pq1.isEmpty() && pq1.peek() > n) {
					pq2.add(pq1.poll());
					pq1.add(n);
				} else {
					pq2.add(n);
				}
			}
			answer.append(pq1.peek()).append("\n");
		}
		System.out.print(answer);
		br.close();
	}
}
