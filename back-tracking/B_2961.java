import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2961
{

    static int N, answer = Integer.MAX_VALUE;
    static Food[] foods;
    static boolean[] check;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        foods = new Food[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            foods[i] = new Food(S, B);
        }
        dfs(0,1, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int S, int B, int cnt) {
        if (depth == N) {
            if (cnt > 0) answer = Math.min(answer, Math.abs(S - B));
            return;
        }
        dfs(depth + 1, S, B, cnt);
        dfs(depth + 1, S * foods[depth].S, B + foods[depth].B, cnt + 1);
    }

    public static class Food {
        int S;
        int B;

        public Food(int S, int B) {
            this.S = S;
            this.B = B;
        }
    }
}