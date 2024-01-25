import java.util.*;
import java.io.*;

public class B_3830 {

	static int[] parent;
	static long[] cost;
	static int N, M;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			parent = new int[N + 1];
			cost = new long[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				if (op == '!') {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int w = Integer.parseInt(st.nextToken());
					union(a, b, w);
				} else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					if (find(a, -1) != find(b, -1)) {
						answer.append("UNKNOWN").append("\n");
					} else {
						answer.append(cost[b] - cost[a]).append("\n");
					}
				}
			}
		}
		System.out.println(answer);
	}

	
	private static void union(int a, int b, int w) {
		int parentA = find(a, -1);
		int parentB = find(b, -1);
		long costA = cost[a];
		long costB = cost[b];
		if (parentA > parentB) {
			parent[parentA] = parentB;
			cost[parentA] = (costB - costA) - w;
		} else {
			parent[parentB] = parentA;
			cost[parentB] = (costA - costB) + w;
		}
	}
	
	private static int find(int a, int before) {
		if (a == parent[a]) {
			return a;
		}
		parent[a] = find(parent[a], a);
		if (before != -1) cost[before] += cost[a];
		return parent[a];
	}
}
