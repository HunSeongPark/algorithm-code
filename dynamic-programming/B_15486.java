import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N + 2];
        int[] DP = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i] = new Node(T, P);
        }
        for (int i = N; i > 0; i--) {
            Node cur = arr[i];
            int day = i + cur.T;
            if (day > N + 1) {
                DP[i] = DP[i + 1];
            } else {
                DP[i] = Math.max(DP[day] + cur.P, DP[i + 1]);
            }
        }
        System.out.println(DP[1]);
    }

    public static class Node {
        int T;
        int P;

        public Node(int t, int p) {
            T = t;
            P = p;
        }
    }
}