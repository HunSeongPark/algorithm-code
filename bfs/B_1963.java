import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1963 {

    static char[] A;
    static int B;
    static int answer;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            isPossible = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken().toCharArray();
            B = Integer.parseInt(st.nextToken());
            bfs();
            if (isPossible) System.out.println(answer);
            else System.out.println("Impossible");
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 0));
        boolean[] visited = new boolean[10000];
        visited[chArrayToInt(A)] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (chArrayToInt(cur.n) == B) {
                answer = cur.w;
                isPossible = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) continue;
                    char[] copy = cur.n.clone();
                    copy[i] = (char) (j + '0');
                    int num = chArrayToInt(copy);
                    if (!visited[num] && isPrime(num)) {
                        visited[num] = true;
                        queue.add(new Node(copy, cur.w + 1));
                    }
                }
            }
        }
    }

    public static int chArrayToInt(char[] arr) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result *= 10;
            result += arr[i] - '0';
        }
        return result;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Node {
        char[] n;
        int w;

        public Node(char[] n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}