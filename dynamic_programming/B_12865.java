import java.io.*;
import java.util.StringTokenizer;

public class B_12865 {

    static int[] w;
    static int[] v;
    static int K;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        int[][] result = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int W = 1; W <= K; W++) {
                if (w[i - 1] > W) {
                    result[i][W] = result[i - 1][W];
                } else {
                    result[i][W] = Math.max(v[i - 1] + result[i - 1][W - w[i - 1]], result[i - 1][W]);
                }
            }
        }
        System.out.println(result[N][K]);
        clear();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[N];
        v = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}