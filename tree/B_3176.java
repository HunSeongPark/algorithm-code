import java.util.*;
import java.io.*;

public class B_3176 {

	static int N, H, M;
	static int[] depth;
	static int[][] parent, max, min;
	static ArrayList<Node>[] adj;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		H = getHeight();
		depth = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		parent = new int[N + 1][H];
		max = new int[N + 1][H];
		min = new int[N + 1][H];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, w));
			adj[b].add(new Node(a, w));
		}
		dfs(1, 1, 0);
		getParent();
		M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lca(a, b);
		}
		System.out.println(answer);
	}
	
	// 최소 공통 조상
	private static void lca(int a, int b) {
		int targetH = 0;
		int maxRes = 0;
		int minRes = Integer.MAX_VALUE;
		// b의 depth가 더 깊도록 swap
		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// depth 차이 비교하며 높이 같아지도록 b depth 조정
		for (targetH = H - 1; targetH >= 0; targetH--) {
			if (Math.pow(2, targetH) <= depth[b] - depth[a]) {
				maxRes = Math.max(maxRes, max[b][targetH]);
				minRes = Math.min(minRes, min[b][targetH]);
				b = parent[b][targetH];
			}
		}
		if (a == b) {
			answer.append(minRes).append(" ").append(maxRes).append("\n");
			return;
		}
		
		// 큰 범위부터 위로 2^i 만큼 점프하며 LCA 수행
		// 공통 부모 만날 때까지
		for (targetH = H - 1; targetH >= 0; targetH--) {
			if (parent[a][targetH] != parent[b][targetH]) {
				maxRes = Math.max(maxRes, max[a][targetH]);
				maxRes = Math.max(maxRes, max[b][targetH]);
				minRes = Math.min(minRes, min[a][targetH]);
				minRes = Math.min(minRes, min[b][targetH]);
				a = parent[a][targetH];
				b = parent[b][targetH];
			}
		}
		
		// 공통 부모 return
		maxRes = Math.max(maxRes, Math.max(max[a][0], max[b][0]));
		minRes = Math.min(minRes, Math.min(min[a][0], min[b][0]));
		answer.append(minRes).append(" ").append(maxRes).append("\n");
	}
	
	// depth 및 parent (parent[n][0]) 초기화	
	private static void dfs(int cur, int height, int pa) {
		depth[cur] = height;
		for (Node node : adj[cur]) {
			if (node.next != pa) {
				dfs(node.next, height + 1, cur);
				parent[node.next][0] = cur;
				max[node.next][0] = node.w;
				min[node.next][0] = node.w;
			}
		}
	}
	
	// parent에 대해 2^h까지 초기화
	private static void getParent() {
		for (int j = 1; j < H; j++) {
			for (int i = 1; i <= N; i++) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
				max[i][j] = Math.max(max[i][j - 1], max[parent[i][j - 1]][j - 1]);
				min[i][j] = Math.min(min[i][j - 1], min[parent[i][j - 1]][j - 1]);
			}
		}
	}

	private static int getHeight() {
		return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
	}
	
	private static class Node {
		int next;
		int w;
		
		public Node(int next, int w) {
			this.next = next;
			this.w = w;
		}
	}
}
