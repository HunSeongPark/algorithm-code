import java.io.*;
import java.util.*;

public class B_1920 {

    static int N;
    static int M;
    static int[] Q;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < M; i++) {
            boolean isFind = false;
            int num = A[i];
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (Q[mid] > num) {
                    end = mid - 1;
                } else if (Q[mid] < num) {
                    start = mid + 1;
                } else {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        clear();
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Q);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}