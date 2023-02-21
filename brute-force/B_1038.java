import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_1038 {

    static int N;
    static int count = 9;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N < 10) {
            System.out.println(N);
            return;
        }
        for (int i = 2; i <= 10; i++) {
            dfs(1, i);
        }
        System.out.println(-1);
    }

    public static void dfs(int depth, int maxDepth) {
        if (depth > maxDepth) {
            count++;
            if (count == N) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : answer) {
                    sb.append(i);
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (i == 0 && depth == 1) continue;
            if (depth > 1 && answer.get(depth - 2) <= i) continue;
            answer.add(i);
            dfs(depth + 1, maxDepth);
            answer.remove(answer.indexOf(i));
        }
    }
}