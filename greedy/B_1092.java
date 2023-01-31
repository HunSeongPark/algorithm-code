import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c.add(Integer.parseInt(st.nextToken()));
        }
        c.sort(Comparator.reverseOrder());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Comparator.reverseOrder());
        if (box.get(0) > c.get(0)) {
            System.out.println(-1);
            return;
        }
        int time = 0;
        while (!box.isEmpty()) {
            time++;
            int idx = 0;
            for (int i = 0; i < N; i++) {
                while (true) {
                    if (idx == box.size()) break;
                    if (box.get(idx) <= c.get(i)) {
                        box.remove(idx);
                        break;
                    } else {
                        idx++;
                    }
                }
            }
        }
        System.out.println(time);
    }
}