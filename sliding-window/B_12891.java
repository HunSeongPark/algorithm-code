import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12891 {
    static int[] check = new int[4];
    static int[] cur = new int[4];
    static char[] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        A = new char[S];
        A = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < P; i++) {
            add(A[i]);
        }
        checkValid();

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            checkValid();
        }
        System.out.println(result);
    }

    public static void add(char ch) {
        if (ch == 'A') {
            cur[0]++;
        } else if (ch == 'C') {
            cur[1]++;
        } else if (ch == 'G') {
            cur[2]++;
        } else {
            cur[3]++;
        }
    }

    public static void remove(char ch) {
        if (ch == 'A') {
            cur[0]--;
        } else if (ch == 'C') {
            cur[1]--;
        } else if (ch == 'G') {
            cur[2]--;
        } else {
            cur[3]--;
        }
    }

    public static void checkValid() {
        if (cur[0] >= check[0] && cur[1] >= check[1] &&
                cur[2] >= check[2] && cur[3] >= check[3]) {
            result++;
        }
    }
}