import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1091 {

    static int N;
    static int[] P;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        boolean isFind = true;
        for (int i = 0; i < N; i++) {
            if (i % 3 != P[i]) {
                isFind = false;
            }
        }
        if (isFind) {
            System.out.println(0);
            return;
        }
        int[] first = P.clone();
        shuffle();
        int result = 1;
        while (true) {
            int state = check(first, P);
            if (state == -1) {
                System.out.println(-1);
                return;
            } else if (state == 0) {
                System.out.println(result);
                return;
            } else {
                shuffle();
                result++;
            }
        }
    }

    public static void shuffle() {
        int[] clone = P.clone();
        for (int i = 0; i < N; i++) {
            P[S[i]] = clone[i];
        }
    }

    public static int check(int[] first, int[] current) {
        boolean isEnd = true;
        boolean isFind = true;
        for (int i = 0; i < N; i++) {
            if (first[i] != current[i]) {
                isEnd = false;
            }
            if (i % 3 != current[i]) {
                isFind = false;
            }
        }
        // 만들지 못함
        if (isEnd) return -1;
        // 찾음
        if (isFind) return 0;
        // 계속 진행
        return 1;
    }
}