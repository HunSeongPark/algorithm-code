import java.io.*;

public class B_9252 {

    static char[] X;
    static char[] Y;
    static final int UP = 0;
    static final int LEFT = 1;
    static final int CROSS = 2;
    static int[][] b;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        int[][] DP = new int[X.length + 1][Y.length + 1];
        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                    b[i][j] = CROSS;
                } else if (DP[i - 1][j] >= DP[i][j - 1]){
                    DP[i][j] = DP[i - 1][j];
                    b[i][j] = UP;
                } else {
                    DP[i][j] = DP[i][j - 1];
                    b[i][j] = LEFT;
                }
            }
        }
        int length = DP[X.length][Y.length];
        if (length == 0) {
            System.out.println(0);
        } else {
            System.out.println(length);
            print_lcs(X.length, Y.length);
            bw.flush();
        }
        clear();
    }

    private static void print_lcs(int i, int j) throws IOException {
        if (i == 0 || j == 0) {
            return;
        } else if (b[i][j] == CROSS) {
            print_lcs(i - 1, j - 1);
            bw.write(X[i - 1]);
        } else if (b[i][j] == LEFT){
            print_lcs(i, j - 1);
        } else {
            print_lcs(i - 1, j);
        }
    }

    private static void input() throws IOException {
        X = br.readLine().toCharArray();
        Y = br.readLine().toCharArray();
        b = new int[X.length + 1][Y.length + 1];
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}