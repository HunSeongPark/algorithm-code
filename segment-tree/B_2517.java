import java.util.*;
import java.io.*;

public class B_2517 {
	
	static int N, offset;
	static int[] rank, indexedTree;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}
		compress();
		for (offset = 1; offset < N; offset *= 2);
		indexedTree = new int[offset * 2 + 2];
		
		/**
		 * 각 선수 실력 indexed tree에 업데이트
		 * 구간합을 통해 자신보다 실력이 낮은 사람 count
		 * 이후 rank 업데이트
		 */
		for (int i = 1; i <= N; i++) {
			update(rank[i]);
			int lowerCount = sum(0, rank[i] - 1);
			answer.append(i - lowerCount).append("\n");
		}
		System.out.println(answer);
		br.close();
	}
	
	private static int sum(int start, int end) {
		start += offset;
		end += offset;
		int ret = 0;
		while (start <= end) {
			if (start % 2 == 1) ret += indexedTree[start++];
			if (end % 2 == 0) ret += indexedTree[end--];
			start /= 2;
			end /= 2;
		}
		return ret;
	}
	
	private static void update(int rank) {
		rank += offset;
		indexedTree[rank]++;
		while (rank > 0) {
			rank /= 2;
			indexedTree[rank] = indexedTree[rank * 2] + indexedTree[rank * 2 + 1];
		}
	}

	/**
	 *  N은 최대 50만
	 *  실력은 최대 10억
	 *  각 선수의 실력은 모두 다름
	 *  실력의 범위가 N에 비해 너무 큼
	 *  실력값을 기준으로 Indexed Tree를 구성해야 하므로 실력값 압축
	 */
	
	private static void compress() {
		int[] sortArr = rank.clone();
		Arrays.sort(sortArr);
		int prev = sortArr[1];
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		map.put(sortArr[1], idx++);
		for (int i = 2; i <= N; i++) {
			if (prev < sortArr[i]) {
				map.put(sortArr[i], idx++);
				prev = sortArr[i];
			}
		}
		for (int i = 1; i <= N; i++) {
			int n = rank[i];
			rank[i] = map.get(n);
		}
	}
}
