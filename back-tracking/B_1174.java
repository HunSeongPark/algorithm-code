import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_1174 {

    static int N;
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        Collections.sort(result);
        try {
            System.out.println(result.get(N - 1));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    private static void dfs(long n, int idx) {
        if (!result.contains(n)) {
            result.add(n);
        }
        if (idx >= 10) {
            return;
        }
        dfs((n * 10) + arr[idx], idx + 1);
        dfs(n, idx + 1);
    }
}