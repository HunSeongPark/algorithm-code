import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] change = {500, 100, 50, 10, 5};
        int result = 0;
        for (int c : change) {
            while (N >= c) {
                result++;
                N -= c;
            }
        }
        System.out.println(result + N);
    }
}