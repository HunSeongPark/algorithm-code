import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > val) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, val));

            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}