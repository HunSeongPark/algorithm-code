import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16936 {

    static int N;
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            ArrayList<Long> copy = new ArrayList<>(arr);
            dfs(arr.get(i), new ArrayList<>(), copy);
        }
    }

    public static void dfs(long n, ArrayList<Long> cur, ArrayList<Long> list) {
        if (cur.size() == N) {
            StringBuilder answer = new StringBuilder();
            for (Long i : cur) {
                answer.append(i).append(" ");
            }
            System.out.println(answer);
            System.exit(0);
        }
        if (!list.contains(n)) {
            return;
        }
        cur.add(n);
        list.remove(list.indexOf(n));
        ArrayList<Long> copy = new ArrayList<>(list);
        if (n % 3 == 0) dfs(n / 3, cur, copy);
        dfs(n * 2, cur, copy);
    }
}