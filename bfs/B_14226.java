import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_14226 {

    static int S;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        bfs();
    }

    public static void bfs() {
        visited[1][0] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.emoji == S) {
                System.out.println(cur.time);
                return;
            }

            // 붙여넣기
            if (cur.emoji + cur.copy <= 2000 && !visited[cur.emoji + cur.copy][cur.copy]) {
                visited[cur.emoji + cur.copy][cur.copy] = true;
                queue.add(new Node(cur.emoji + cur.copy, cur.time + 1, cur.copy));
            }

            // 복사
            if (cur.emoji * 2 <= 2000 && cur.emoji != cur.copy && !visited[cur.emoji][cur.emoji]) {
                visited[cur.emoji][cur.emoji] = true;
                queue.add(new Node(cur.emoji, cur.time + 1, cur.emoji));
            }

            // 화면에 있는 이모티콘 중 하나 삭제
            if (cur.emoji > 0 && !visited[cur.emoji - 1][cur.copy])  {
                visited[cur.emoji - 1][cur.copy] = true;
                queue.add(new Node(cur.emoji - 1, cur.time + 1, cur.copy));
            }
        }
    }

    public static class Node {
        int emoji;
        int time;
        int copy;

        public Node(int emoji, int time, int copy) {
            this.emoji = emoji;
            this.time = time;
            this.copy = copy;
        }
    }
}