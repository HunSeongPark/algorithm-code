import java.util.*;
import java.io.*;

public class B_5639 {

	static final int LEFT = 0;
	static final int RIGHT = 1;
	static int[][] tree = new int[1000000][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int root = Integer.parseInt(br.readLine());
		while (true) {
			String s = br.readLine();
			if (s == null) break;
			int n = Integer.parseInt(s);
			makeBST(root, n);
		}
		postOrder(root);
		br.close();
	}
	
	private static void postOrder(int n) {
		if (n == 0) return;
		postOrder(tree[n][LEFT]);
		postOrder(tree[n][RIGHT]);
		System.out.println(n);
	}

	private static void makeBST(int cur, int n) {
		if (cur < n) {
			if (tree[cur][RIGHT] != 0) {
				makeBST(tree[cur][RIGHT], n);
			} else {
				tree[cur][RIGHT] = n;
				return;
			}
		} else {
			if (tree[cur][LEFT] != 0) {
				makeBST(tree[cur][LEFT], n);
			} else {
				tree[cur][LEFT] = n;
				return;
			}
		}
	}
}
