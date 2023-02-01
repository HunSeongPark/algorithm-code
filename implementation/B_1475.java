import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] num = new int[10];
        for (int i = 0; i < n.length(); i++) {
            num[n.charAt(i) - '0']++;
        }
        int max = ((num[6] + num[9]) % 2) + ((num[6] + num[9]) / 2);
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, num[i]);
        }
        System.out.println(max);
    }
}