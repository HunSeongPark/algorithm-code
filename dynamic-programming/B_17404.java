import java.util.*;
import java.io.*;

class B_17404 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][][] DP = new int[N][3][3];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(DP[i][j], 1000000);
            }
        }
        DP[0][0][0] = map[0][0];
        DP[0][1][1] = map[0][1];
        DP[0][2][2] = map[0][2];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    DP[i][j][k] = Math.min(DP[i - 1][(j + 1) % 3][k], DP[i - 1][(j + 2) % 3][k]) + map[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                min = Math.min(min, DP[N - 1][i][j]);
            }
        }
        System.out.println(min);
    }
}
