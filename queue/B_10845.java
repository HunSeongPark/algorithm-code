import java.util.*;
import java.io.*;

public class B_10845 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String[] op = br.readLine().split(" ");
			if (op[0].equals("push")) {
				int n = Integer.parseInt(op[1]);
				queue.addLast(n);
			} else if (op[0].equals("pop")) {
				answer.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
			} else if (op[0].equals("size")) {
				answer.append(queue.size()).append("\n");
			} else if (op[0].equals("empty")) {
				answer.append(queue.isEmpty() ? 1 : 0).append("\n");
			} else if (op[0].equals("front")) {
				answer.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
			} else if (op[0].equals("back")) {
				answer.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
			}
		}
		System.out.println(answer);
		br.close();
	}
}
