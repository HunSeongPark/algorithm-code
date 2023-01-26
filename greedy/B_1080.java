import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == B[i][j]) {
                    continue;
                } else if (i + 3 > N || j + 3 > M) {
                    System.out.println(-1);
                    return;
                } else {
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            A[x][y] = (A[x][y] + 1) % 2;
                        }
                    }
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}