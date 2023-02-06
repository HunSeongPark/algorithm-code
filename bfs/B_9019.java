import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1:24
public class B_9019 {

    static int T, A, B;
    static String[] command;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            command = new String[10000];
            Arrays.fill(command, "");
            visited = new boolean[10000];
            bfs();
        }
    }

    public static void bfs() {
        visited[A] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == B) {
                System.out.println(command[poll]);
                return;
            }
            int D = poll * 2 % 10000;
            int S = poll - 1 < 0 ? 9999 : poll - 1;
            int L = (poll % 1000) * 10 + (poll / 1000);
            int R = poll / 10 + (poll % 10) * 1000;
            if (!visited[D]) {
                visited[D] = true;
                queue.add(D);
                command[D] = command[poll] + "D";
            }
            if (!visited[S]) {
                visited[S] = true;
                queue.add(S);
                command[S] = command[poll] + "S";
            }
            if (!visited[L]) {
                visited[L] = true;
                queue.add(L);
                command[L] = command[poll] + "L";
            }
            if (!visited[R]) {
                visited[R] = true;
                queue.add(R);
                command[R] = command[poll] + "R";
            }
        }
    }
}