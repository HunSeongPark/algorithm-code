import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_10819 {

    static int N;
    static int[] arr;
    static int[] select;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[N];
        select = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int count) {
        if (count == N) {
            check();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[count] = arr[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    public static void check() {
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += Math.abs(select[i - 1] - select[i]);
        }
        answer = Math.max(answer, sum);
    }
}