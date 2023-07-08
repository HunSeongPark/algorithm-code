import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[N];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (nodes[i].w < nodes[j].w && nodes[i].h < nodes[j].h) rank[i]++;
            }
        }
        for (int i : rank) {
            System.out.print(i + " ");
        }
    }

    public static class Node {
        int w;
        int h;

        public Node(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}