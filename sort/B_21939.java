import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_21939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        SortedSet<Problem> set = new TreeSet<>();
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Problem(l, p));
            map.put(p, l);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("recommend")) {
                int sort = Integer.parseInt(st.nextToken());
                if (sort == 1) {
                    answer.append(set.last().p).append("\n");
                } else {
                    answer.append(set.first().p).append("\n");
                }
            } else if (op.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.add(new Problem(l, p));
                map.put(p, l);
            } else {
                int p = Integer.parseInt(st.nextToken());
                int l = map.get(p);
                set.remove(new Problem(l, p));
            }
        }
        System.out.println(answer);
    }

    public static class Problem implements Comparable<Problem> {
        int l;
        int p;

        public Problem(int l, int p) {
            this.l = l;
            this.p = p;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.l == o.l) {
                return this.p - o.p;
            }
            return this.l - o.l;
        }
    }
}