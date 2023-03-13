import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_17305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> five = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (w == 3) {
                three.add(v);
            } else {
                five.add(v);
            }
        }
        three.sort(Collections.reverseOrder());
        five.sort(Collections.reverseOrder());
        long[] threeSum = new long[three.size() + 1];
        long[] fiveSum = new long[five.size() + 1];
        for (int i = 1; i <= three.size(); i++) threeSum[i] = three.get(i - 1) + threeSum[i - 1];
        for (int i = 1; i <= five.size(); i++) fiveSum[i] = five.get(i - 1) + fiveSum[i - 1];
        long answer = 0;
        int threeIdx = Math.min(W / 3, three.size());
        while (threeIdx >= 0) {
            int fiveIdx = Math.min((W - threeIdx * 3) / 5, five.size());
            answer = Math.max(answer, threeSum[threeIdx] + fiveSum[fiveIdx]);
            threeIdx--;
        }
        System.out.println(answer);
    }
}