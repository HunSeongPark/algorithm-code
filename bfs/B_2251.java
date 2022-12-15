import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2251 {

    static int A;
    static int B;
    static int C;
    static boolean[][] visited;
    static boolean[] result;
    static int[] send = {0, 0, 1, 1, 2, 2};
    static int[] receive = {1, 2, 0, 2, 0, 1};
    static int[] bottle;
    static Queue<Integer[]> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        for (int i = 0; i <= C; i++) {
            if (result[i]) {
                System.out.print(i + " ");
            }
        }
        clear();
    }

    public static void bfs() {
        visited[0][0] = true;
        result[C] = true;
        queue.add(new Integer[]{0, 0, C});
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            for (int i = 0; i < 6; i++) {
                int[] cur = new int[]{poll[0], poll[1], poll[2]};
                // 보내는 물통 값 변경
                int temp = cur[send[i]];
                cur[send[i]] = 0;
                // 받는 물통 값 변경
                cur[receive[i]] = cur[receive[i]] + temp;
                if (cur[receive[i]] > bottle[receive[i]]) {
                    int mod = cur[receive[i]] - bottle[receive[i]];
                    cur[send[i]] = mod;
                    cur[receive[i]] -= mod;
                }
                if (!visited[cur[0]][cur[1]]) {
                    visited[cur[0]][cur[1]] = true;
                    if (cur[0] == 0) {
                        result[cur[2]] = true;
                    }
                    queue.add(new Integer[]{cur[0], cur[1], cur[2]});
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C + 1][C + 1];
        result = new boolean[C + 1];
        bottle = new int[]{A, B, C};
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}