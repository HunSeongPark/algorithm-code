import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14425 {

    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Node root = new Node();
        int result = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Node cur = root;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (cur.next[ch - 'a'] == null) {
                    cur.next[ch - 'a'] = new Node();
                }
                cur = cur.next[ch - 'a'];
                if (j == str.length() - 1) {
                    cur.isLast = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            Node cur = root;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (cur.next[ch - 'a'] == null) {
                    break;
                }
                cur = cur.next[ch - 'a'];
                if (j == str.length() - 1 && cur.isLast) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isLast;
    }
}
