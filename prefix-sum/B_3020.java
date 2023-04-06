import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] top = new int[H + 2];
        int[] bot = new int[H + 2];
        for (int i = 0; i < N / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }
        for (int i = 1; i <= H; i++) {
            bot[i] += bot[i - 1];
        }
        for (int i = H; i > 0; i--) {
            top[i] += top[i + 1];
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int result = (top[1] - top[i + 1]) + (bot[H] - bot[i - 1]);
            if (min > result) {
                min = result;
                count = 1;
            } else if (min == result) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
}