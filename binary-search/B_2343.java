import java.io.*;
import java.util.*;

public class B_2343 {

    static int N;
    static int M;
    static int sum = 0;
    static int max = 0;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = (start + end) / 2;
            int lesson_sum = 0;
            int cnt = 1;
            boolean ok = true;
            for (int i = 0; i < N; i++) {
                if (lesson_sum + A[i] <= mid) {
                    lesson_sum += A[i];
                } else {
                    cnt++;
                    lesson_sum = A[i];
                }
                if (cnt > M) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        clear();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] > max) {
                max = A[i];
            }
            sum += A[i];
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}