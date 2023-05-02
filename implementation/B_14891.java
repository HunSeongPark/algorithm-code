import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_14891 {

    static char[][] arr = new char[4][8];
    static final char S = '1';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(n - 1, dir);
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == S) {
                answer += Math.pow(2, i);
            }
        }
        System.out.println(answer);
    }

    public static void rotate(int n, int dir) {
        ArrayList<Node> change = new ArrayList<>();
        int d = dir;
        for (int i = n; i < 3; i++) {
            if (arr[i][2] != arr[i + 1][6]) {
                d *= -1;
                change.add(new Node(i + 1, d));
            } else {
                break;
            }
        }
        d = dir;
        for (int i = n; i > 0; i--) {
            if (arr[i][6] != arr[i - 1][2]) {
                d *= -1;
                change.add(new Node(i - 1, d));
            } else {
                break;
            }
        }
        char[] copy = arr[n].clone();
        for (int i = 0; i < 8; i++) {
            int k = i - dir;
            if (k == 8) {
                k = 0;
            } else if (k < 0) {
                k = 7;
            }
            arr[n][i] = copy[k];
        }
        for (Node node : change) {
            copy = arr[node.n].clone();
            for (int j = 0; j < 8; j++) {
                int k = j - node.dir;
                if (k == 8) {
                    k = 0;
                } else if (k < 0) {
                    k = 7;
                }
                arr[node.n][j] = copy[k];
            }
        }
    }

    public static class Node {
        int n;
        int dir;

        public Node(int n, int dir) {
            this.n = n;
            this.dir = dir;
        }
    }
}