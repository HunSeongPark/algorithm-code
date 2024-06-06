import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_19598 {

    static int N, result;
    // 회의 시작 빠른 순 PQ
    static PriorityQueue<Meeting> meet = new PriorityQueue<>();
    // 회의실 종료시간 빠른 순 PQ
    static PriorityQueue<Integer> room = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meet.add(new Meeting(start, end));
        }
        while (!meet.isEmpty()) {
            Meeting cur = meet.poll();
            // 회의실 새로 배정 (첫 회의 or 비어있는 회의실 없는 경우)
            if (room.isEmpty() || cur.start < room.peek()) {
                result++;
                room.add(cur.end);
            } else {
                // 기존 회의실 사용
                room.poll();
                room.add(cur.end);
            }
        }
        System.out.println(result);
    }

    static class Meeting implements Comparable<Meeting> {
        private final int start;
        private final int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 시작시간 빠른 순 / 같을 경우 종료시간 빠른 순
        @Override
        public int compareTo(Meeting obj) {
            if (this.start == obj.start) {
                return obj.end - this.end;
            }
            return this.start - obj.start;
        }
    }
}