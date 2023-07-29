import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1039 {

    static final int MAX = 1_000_001;
    static boolean[][] visited = new boolean[MAX][11];
    static int N, K, size, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        size = String.valueOf(N).length();
        if (N < 10 || (N < 100 && N % 10 == 0)) {
            System.out.println(-1);
            return;
        }
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.cnt == K) {
                answer = Math.max(answer, cur.n);
                continue;
            }
            char[] chArr = intToChArr(cur.n);
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (chArr[j] == '0' && i == 0) continue;
                    char tmpI = chArr[i];
                    char tmpJ = chArr[j];
                    chArr[i] = tmpJ;
                    chArr[j] = tmpI;
                    int n = chArrToInt(chArr);
                    if (!visited[n][cur.cnt + 1]) {
                        visited[n][cur.cnt + 1] = true;
                        queue.add(new Node(n, cur.cnt + 1));
                    }
                    chArr[i] = tmpI;
                    chArr[j] = tmpJ;
                }
            }
        }
    }

    private static char[] intToChArr(int n) {
        return String.valueOf(n).toCharArray();
    }

    private static int chArrToInt(char[] arr) {
        return Integer.parseInt(String.valueOf(arr));
    }

    private static class Node {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
