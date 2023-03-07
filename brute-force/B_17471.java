import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12:35
public class B_17471 {

    static int N;
    static int sum = 0;
    static int answer = Integer.MAX_VALUE;
    static int[] people;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        adj = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            people[i] = Integer.parseInt(st.nextToken());
            sum += people[i];
        }
        for (int u = 1; u <= N; u++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }
        }
        for (int i = 1; i <= N / 2; i++) {
            dfs(1, i);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int idx, int size) {
        if (selected.size() == size) {
            if (!bfs(selected)) return;
            ArrayList<Integer> selected2 = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!selected.contains(i)) {
                    selected2.add(i);
                }
            }
            if (!bfs(selected2)) return;
            int selectedSum = 0;
            for (int i = 0; i < selected.size(); i++) {
                selectedSum += people[selected.get(i)];
            }
            answer = Math.min(answer, Math.abs(selectedSum - (sum - selectedSum)));
            return;
        }
        for (int i = idx; i <= N; i++) {
            selected.add(i);
            dfs(idx + 1, size);
            selected.remove(selected.size() - 1);
        }
    }

    public static boolean bfs(ArrayList<Integer> sel) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int count = 1;
        visited[sel.get(0)] = true;
        queue.add(sel.get(0));
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer n : adj[poll]) {
                if (sel.contains(n) && !visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    count++;
                }
            }
        }
        return count == sel.size();
    }
}