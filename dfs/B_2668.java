import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 2:51
public class B_2668 {

    static int N;
    static int[] A;
    static boolean[] visited;
    static int start;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            start = i;
            dfs(i);
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static boolean dfs(int i) {
        if (A[i] == start) {
            if (!result.contains(i)) {
                result.add(i);
            }
            return true;
        }
        visited[i] = true;
        if (!visited[A[i]] && dfs(A[i])) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }
        visited[i] = false;
        return false;
    }
}