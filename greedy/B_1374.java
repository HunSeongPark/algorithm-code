import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> wait = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            wait.add(new int[]{start, end});
        }
        int answer = 0;
        while (!wait.isEmpty()) {
            int[] cur = wait.poll();
            if (room.isEmpty()) {
                answer++;
                room.add(cur[1]);
            } else if (cur[0] < room.peek()) {
                answer++;
                room.add(cur[1]);
            } else {
                room.poll();
                room.add(cur[1]);
            }
        }
        System.out.println(answer);
    }
}