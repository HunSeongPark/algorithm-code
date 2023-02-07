import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1:40
public class B_9205 {

    static int T, n;
    static Node start;
    static Node end;
    static Node[] conv;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            conv = new Node[n];
            visited = new boolean[n];
            int idx = 0;
            StringTokenizer st;
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                if (i == 0) {
                    start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else if (i == n + 1) {
                    end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else {
                    conv[idx++] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
            }
            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    public static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start.i, start.j));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (Math.abs(poll.i - end.i) + Math.abs(poll.j - end.j) <= 1000) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                Node con = conv[i];
                if (!visited[i] && Math.abs(poll.i - con.i) + Math.abs(poll.j - con.j) <= 1000) {
                    visited[i] = true;
                    queue.add(new Node(con.i, con.j));
                }
            }
        }
        return false;
    }

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}