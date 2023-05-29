import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_1153 {

    static int N;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;
            for (int j = i * 2; j <= N; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = 2; i <= N; i++) {
            if (arr[i] != 0) primes.add(i);
        }
        dfs(0, 0, new ArrayList<>(), 0);
        System.out.println(-1);
    }

    public static void dfs(int idx, int depth, ArrayList<Integer> selected, int sum) {
        if (depth == 3) {
            if (selected.contains(N - sum)) {
                for (Integer integer : selected) {
                    System.out.print(integer + " ");
                }
                System.out.print(N - sum);
                System.exit(0);
            }
            return;
        }
        for (int i = idx; i < primes.size(); i++) {
            if (sum + primes.get(i) > N || (sum + primes.get(i) == N && primes.size() < 3)) continue;
            selected.add(primes.get(i));
            dfs(i, depth + 1, selected, sum + primes.get(i));
            selected.remove(selected.size() - 1);
        }
    }
}
