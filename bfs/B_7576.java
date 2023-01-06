import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        int[][] A = new int[N][M];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < M && A[x][y] == 0) {
                    A[x][y] = 1;
                    queue.add(new Node(x, y, poll.day + 1));
                    result = poll.day + 1;
                }
            }
        }
        boolean isFail = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    isFail = true;
                    break;
                }
            }
        }
        if (isFail) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static class Node {
        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}