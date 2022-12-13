import java.io.*;
import java.util.StringTokenizer;

public class B_11054 {

    static int N;
    static Integer[] A;
    static Integer[] lis;
    static Integer[] lds;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            LIS(i);
        }
        for (int i = N - 1; i >= 0; i--) {
            LDS(i);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lis[i] + lds[i]);
        }
        System.out.println(max - 1);
        clear();
    }

    private static void LIS(int n) {
        if (lis[n] == null) {
            lis[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (A[i] < A[n]) {
                    lis[n] = Math.max(lis[i] + 1, lis[n]);
                }
            }
        }
    }

    private static void LDS(int n) {
        if (lds[n] == null) {
            lds[n] = 1;
            for (int i = n + 1; i < N; i++) {
                if (A[i] < A[n]) {
                    lds[n] = Math.max(lds[i] + 1, lds[n]);
                }
            }
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        lis = new Integer[N];
        lds = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}