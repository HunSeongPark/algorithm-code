import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_12852 {

    static Node answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bfs();
        System.out.println(answer.count + "\n" + answer.s);
    }

    public static void bfs() {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0, String.valueOf(N)));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.num == 1) {
                answer = cur;
                return;
            }
            if (cur.num % 3 == 0 && !visited[cur.num / 3]) {
                visited[cur.num / 3] = true;
                queue.add(new Node(cur.num / 3, cur.count + 1, cur.s + " " + cur.num / 3));
            }
            if (cur.num % 2 == 0 && !visited[cur.num / 2]) {
                visited[cur.num / 2] = true;
                queue.add(new Node(cur.num / 2, cur.count + 1, cur.s + " " + cur.num / 2));
            }
            if (!visited[cur.num - 1]) {
                visited[cur.num - 1] = true;
                queue.add(new Node(cur.num - 1, cur.count + 1, cur.s + " " + (cur.num - 1)));
            }
        }
    }

    public static class Node {
        int num;
        int count;
        String s;

        public Node(int num, int count, String s) {
            this.num = num;
            this.count = count;
            this.s = s;
        }
    }
}