import java.util.*;
import java.io.*;

public class B_11400 {

	static int V, E, o = 1;
	static ArrayList<Integer>[] adj;
	static ArrayList<Node> result = new ArrayList<>();
	static int[] order;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V + 1];
		order = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		for (int i = 1; i <= V; i++) {
			if (order[i] == 0) {
				dfs(i, 0);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (Node n : result) {
			answer.append(n.a).append(" ").append(n.b).append("\n");
		}
		System.out.println(answer);
	}

	private static int dfs(int cur, int parent) {
		// order 기록
		order[cur] = o++;
		
		// 방문한 최소 order 반환 (역전 현상 확인)
		int ret = order[cur];
		
		// 인접 노드 모두 확인
		for (int next : adj[cur]) {
			if (next == parent) continue;
			if (order[next] == 0) {
				// 자식 정점 중 방문순서 가장 빠른 값
				int lowOrder = dfs(next, cur);
				// order 역전 불가능시 단절선
				if (lowOrder > order[cur]) {
					result.add(new Node(Math.min(cur, next), Math.max(cur, next)));
				}
				ret = Math.min(ret, lowOrder);
			} else {
				ret = Math.min(ret, order[next]);
			}
		}
		return ret;
	}
	
	private static class Node implements Comparable<Node> {
		int a;
		int b;
		
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			if (this.a == o.a) {
				return this.b - o.b;
			}
			return this.a - o.a;
		}
		
		
	}
}
