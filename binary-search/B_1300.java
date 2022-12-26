import java.io.*;
import java.util.*;

public class B_1300 {

    static int N;
    static int k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        long start = 1;
        long end = k;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
        clear();
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}