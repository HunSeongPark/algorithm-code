import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[N];
        int[] bag = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new Node(w, v);
        }
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Arrays.sort(bag);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int j = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {
            int b = bag[i];
            while (j < N && arr[j].w <= b) {
                queue.add(arr[j++].v);
            }
            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }
        System.out.println(result);
    }

    public static class Node implements Comparable<Node> {
        int w;
        int v;

        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}