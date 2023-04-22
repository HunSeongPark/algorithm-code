import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9184 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int[][][] DP = new int[21][21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                DP[i][j][0] = DP[i][0][j] = DP[0][i][j] = 1;
            }
        }
        for (int A = 1; A <= 20; A++) {
            for (int B = 1; B <= 20; B++) {
                for (int C = 1; C <= 20; C++) {
                    if (A < B && B < C) {
                        DP[A][B][C] = DP[A][B][C - 1] + DP[A][B - 1][C - 1] - DP[A][B - 1][C];
                    } else {
                        DP[A][B][C] = DP[A - 1][B][C] + DP[A - 1][B - 1][C] + DP[A - 1][B][C - 1] - DP[A - 1][B - 1][C - 1];
                    }
                }
            }
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == b && b == c && c == -1) {
                System.out.println(answer);
                break;
            }
            answer.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            if (a <= 0 || b <= 0 || c <= 0) {
                answer.append(DP[0][0][0]).append("\n");
            } else if (a > 20 || b > 20 || c > 20) {
                answer.append(DP[20][20][20]).append("\n");
            } else {
                answer.append(DP[a][b][c]).append("\n");
            }
        }
    }
}