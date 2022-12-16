import java.io.*;
import java.util.*;

public class B_2252 {

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        ArrayList<Integer>[] A;
        int[] indegree;
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
        }
        for (int i = 1; i <= N; i++) {
            for (Integer j : A[i]) {
                indegree[j]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            for (Integer i : A[poll]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}