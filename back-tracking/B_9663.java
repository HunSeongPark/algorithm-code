import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9663 {

    static int N;
    static int[] col;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int row) {
        if (row >= N) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
                boolean isOk = true;
                for (int j = 0; j < row; j++) {
                    if (!isValid(row, i, j, col[j])) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    col[row] = i;
                    dfs(row + 1);
                }
            }
        }
    }

    private static boolean isValid(int i1, int j1, int i2, int j2) {
        return (i1 != i2) && (j1 != j2) && (i1 + j1 != i2 + j2) && (i1 - j1 != i2 - j2);
    }
}
