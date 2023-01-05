import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] D = new int[N + 1];
            int[] indegree = new int[N + 1];
            int[] result = new int[N + 1];
            ArrayList<Integer>[] A = new ArrayList[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                A[i] = new ArrayList<>();
                D[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                A[X].add(Y);
                indegree[Y]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    result[i] = D[i];
                }
            }
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (Integer i : A[poll]) {
                    result[i] = Math.max(result[i], result[poll] + D[i]);
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
            int W = Integer.parseInt(br.readLine());
            System.out.println(result[W]);
        }
    }
}