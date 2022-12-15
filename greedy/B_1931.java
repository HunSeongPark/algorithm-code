import java.io.*;
import java.util.*;

public class B_1931 {

    static int N;
    static int[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        int result = 0;
        int end_time = -1;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end_time) {
                result++;
                end_time = A[i][1];
            }
        }
        System.out.println(result);
        clear();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[i][0] = start;
            A[i][1] = end;
        }
        Arrays.sort(A, (a1, a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        });
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}