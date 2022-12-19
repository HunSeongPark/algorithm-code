import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10769 {

    public static void main(String[] args) throws IOException {
        char[] str;
        int[] count = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        for (int i = 0; i < str.length - 2; i++) {
            if (str[i] == ':' && str[i + 1] == '-' && str[i + 2] == ')') {
                count[0]++;
            } else if (str[i] == ':' && str[i + 1] == '-' && str[i + 2] == '(') {
                count[1]++;
            }
        }
        if (count[0] == count[1]) {
            if (count[0] == 0) {
                System.out.println("none");
            } else {
                System.out.println("unsure");
            }
        } else if (count[0] > count[1]) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
        br.close();
    }
}