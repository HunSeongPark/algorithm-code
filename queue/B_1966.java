import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] priority = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                priority[i] = Integer.parseInt(st.nextToken());
                queue.add(i);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                boolean isPoll = true;
                for (Integer i : queue) {
                    if (priority[cur] < priority[i]) {
                        isPoll = false;
                        break;
                    }
                }
                if (isPoll) {
                    count++;
                    if (cur == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(cur);
                }
            }
        }
    }
}