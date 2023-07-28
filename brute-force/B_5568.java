import java.util.*;
import java.io.*;

public class B_5568 {
	
	static int N, K;
	static int[] arr;
	static ArrayList<Integer> selected = new ArrayList<>();
	static boolean[] visited;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		permutation(0);
		System.out.println(set.size());
		br.close();
	}
	
	private static void permutation(int count) {
		if (count == K) {
			StringBuilder s = new StringBuilder();
			for (int i : selected) {
				s.append(i);
			}
			set.add(Integer.parseInt(s.toString()));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected.add(arr[i]);
				permutation(count + 1);
				selected.remove(selected.size() - 1);
				visited[i] = false;
			}
		}
		
	}
}
