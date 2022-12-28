import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14888 {

    static int N;
    static int[] A;
    static int[] Op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            Op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int count, int value) {
        if (count == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if (Op[i] > 0) {
                    Op[i]--;
                    if (i == 0) {
                        dfs(count + 1, value + A[count + 1]);
                    } else if (i == 1) {
                        dfs(count + 1, value - A[count + 1]);
                    } else if (i == 2) {
                        dfs(count + 1, value * A[count + 1]);
                    } else {
                        dfs(count + 1, value / A[count + 1]);
                    }
                    Op[i]++;
                }
            }
        }
    }
}
