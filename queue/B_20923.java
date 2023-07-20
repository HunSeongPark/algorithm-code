import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_20923 {

    static Deque<Integer> d = new ArrayDeque<>();
    static Deque<Integer> s = new ArrayDeque<>();
    static Queue<Integer> d_ground = new LinkedList<>();
    static Queue<Integer> s_ground = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            d.addFirst(Integer.parseInt(st.nextToken()));
            s.addFirst(Integer.parseInt(st.nextToken()));
        }
        int d_top = 0;
        int s_top = 0;
        while (M > 0) {
            if (checkEnd()) {
                return;
            }
            d_top = d.removeFirst();
            d_ground.add(d_top);
            if (checkEnd()) {
                return;
            }
            if (d_top == 5) {
                d_top = 0;
                s_top = 0;
                updateD();
            } else if (d_top + s_top == 5) {
                d_top = 0;
                s_top = 0;
                updateS();
            }
            M--;
            if (M == 0) break;
            s_top = s.removeFirst();
            s_ground.add(s_top);
            if (s_top == 5) {
                d_top = 0;
                s_top = 0;
                updateD();
            } else if (d_top + s_top == 5) {
                d_top = 0;
                s_top = 0;
                updateS();
            }
            M--;
        }
        if (d.size() > s.size()) {
            System.out.println("do");
        } else if (d.size() < s.size()) {
            System.out.println("su");
        } else {
            System.out.println("dosu");
        }
    }

    public static boolean checkEnd() {
        if (d.isEmpty() || s.isEmpty()) {
            if (d.isEmpty()) System.out.println("su");
            else System.out.println("do");
            return true;
        }
        return false;
    }

    public static void updateD() {
        while (!s_ground.isEmpty()) {
            d.addLast(s_ground.remove());
        }
        while (!d_ground.isEmpty()) {
            d.addLast(d_ground.remove());
        }
    }

    public static void updateS() {
        while (!d_ground.isEmpty()) {
            s.addLast(d_ground.remove());
        }
        while (!s_ground.isEmpty()) {
            s.addLast(s_ground.remove());
        }
    }
}
