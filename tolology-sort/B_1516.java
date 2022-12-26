import java.io.*;
import java.util.*;

public class B_1516 {

    public static void main(String[] args) throws IOException {
        int N;
        ArrayList<Integer>[] A;
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree;
        int[] cost;
        int[] result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        indegree = new int[N + 1];
        cost = new int[N + 1];
        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        // 각 건물의 cost, 인접리스트, 진입차수(indegree) 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) {
                    break;
                }
                A[u].add(i);
                indegree[i]++;
            }
        }
        // 진입차수 0인 건물 queue에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 그래프 순회하며 위상정렬 수행
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : A[poll]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
                result[i] = Math.max(result[i], result[poll] + cost[poll]);
            }
        }
        // 결과에 자신의 건물 짓는 시간 추가
        for (int i = 1; i <= N; i++) {
            result[i] += cost[i];
        }
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}