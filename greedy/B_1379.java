import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1379 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Room> room_pq = new PriorityQueue<>();
        PriorityQueue<Lecture> lec_pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lec_pq.add(new Lecture(num, start, end));
        }
        int idx = 1;
        while (!lec_pq.isEmpty()) {
            Lecture cur = lec_pq.poll();
            // 새로운 강의실 배정
            if (room_pq.isEmpty() || room_pq.peek().end > cur.start) {
                answer[cur.num] = idx;
                room_pq.add(new Room(idx++, cur.end));
            } else {
                // 기존 강의실 할당
                Room room = room_pq.poll();
                answer[cur.num] = room.num;
                room_pq.add(new Room(room.num, cur.end));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(idx - 1).append("\n");
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static class Room implements Comparable<Room> {
        int num;
        int end;

        public Room(int num, int end) {
            this.num = num;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }
    }

    public static class Lecture implements Comparable<Lecture> {
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}