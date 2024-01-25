import java.util.*;
import java.io.*;

public class B_11266 {

	static int V, E, o = 1;
	static ArrayList<Integer>[] adj;
	static int[] order;
	static boolean[] isCheck;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V + 1];
		order = new int[V + 1];
		isCheck = new boolean[V + 1];
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
				dfs(i, 0, true);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= V; i++) {
			if (isCheck[i]) {
				cnt++;
				answer.append(i).append(" ");
			}
		}
		System.out.println(cnt);
		System.out.println(answer);
	}

	private static int dfs(int cur, int parent, boolean isRoot) {
		// order 기록
		order[cur] = o++;
		
		// 방문한 최소 order 반환 (역전 현상 확인)
		int ret = order[cur];
		int childCnt = 0;
		
		// 인접 노드 모두 확인
		for (int next : adj[cur]) {
			if (next == parent) continue;
			if (order[next] == 0) {
				childCnt++;
				// 자식 정점 중 방문순서 가장 빠른 값
				int lowOrder = dfs(next, cur, false);
				// Root가 아니면서, order 역전 불가능시 단절점
				if (!isRoot && lowOrder >= order[cur]) {
					isCheck[cur] = true;
				}
				ret = Math.min(ret, lowOrder);
			} else {
				ret = Math.min(ret, order[next]);
			}
		}
		if (isRoot && childCnt >= 2) {
			isCheck[cur] = true;
		}
		return ret;
	}
}
