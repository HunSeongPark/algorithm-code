import java.io.*;
import java.util.*;

public class B_11047 {

    static int N;
    static int K;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int coin = A[i];
            if (K >= coin) {
                result += K / coin;
                K = K % coin;
            }
            if (K == 0) {
                break;
            }
        }
        System.out.println(result);
        clear();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}