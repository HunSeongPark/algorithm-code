import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1436 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = 666;
        int count = 1;
        while (count != N) {
            M++;
            if (String.valueOf(M).contains("666")) count++;
        }
        System.out.println(M);
    }
}