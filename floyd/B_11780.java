import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_11780 {

    static int[][] distance;
    static int[][] path;
    static int N, M;
    static final int MAX = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distance = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) distance[i][j] = MAX;
            }
        }
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Math.min(distance[a][b], c);
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer.append(distance[i][j] == MAX ? 0 : distance[i][j]).append(" ");
            }
            answer.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                LinkedList<Integer> p = new LinkedList<>();
                if (i != j && distance[i][j] != MAX) findPath(i, j, p);
                answer.append(p.size()).append(" ");
                for (int n : p) {
                    answer.append(n).append(" ");
                }
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }

    public static void findPath(int i, int j, LinkedList<Integer> p) {
        if (path[i][j] == 0) {
            p.addLast(i);
            p.addLast(j);
            return;
        }
        findPath(i, path[i][j], p);
        p.removeLast();
        findPath(path[i][j], j, p);
    }
}
