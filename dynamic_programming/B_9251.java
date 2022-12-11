import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9251 {

    static char[] X;
    static char[] Y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int[][] DP = new int[X.length + 1][Y.length + 1];
        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[X.length][Y.length]);
        clear();
    }

    private static void input() throws IOException {
        X = br.readLine().toCharArray();
        Y = br.readLine().toCharArray();
    }

    private static void clear() throws IOException {
        br.close();
    }
}