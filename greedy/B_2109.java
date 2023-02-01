import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2 :23
public class B_2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Element> A = new ArrayList<>();
        StringTokenizer st;
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            A.add(new Element(day, money));
            maxDay = Math.max(maxDay, day);
        }
        int result = 0;

        for (int i = maxDay; i > 0; i--) {
            int idx = -1;
            int value = 0;
            for (int j = 0; j < A.size(); j++) {
                if (i <= A.get(j).day && value < A.get(j).money) {
                    idx = j;
                    value = A.get(j).money;
                }
            }
            if (idx != -1) {
                result += value;
                A.remove(idx);
            }
        }
        System.out.println(result);
    }

    public static class Element {
        int day;
        int money;

        public Element(int day, int money) {
            this.day = day;
            this.money = money;
        }
    }
}