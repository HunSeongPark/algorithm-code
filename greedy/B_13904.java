import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_13904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Element> e = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            e.add(new Element(day, score));
            max = Math.max(max, day);
        }
        int result = 0;
        for (int i = max; i > 0; i--) {
            int idx = -1;
            int select = 0;
            for (int j = 0; j < e.size(); j++) {
                if (i <= e.get(j).day) {
                    if (select < e.get(j).score) {
                        select = e.get(j).score;
                        idx = j;
                    }
                }
            }
            if (idx != -1) {
                result += select;
                e.remove(idx);
            }
        }
        System.out.println(result);
    }

    public static class Element {
        int day;
        int score;

        public Element(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}