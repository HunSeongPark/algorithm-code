import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_11508 {

    public static void main(String[] args) throws IOException {
        int N;
        ArrayList<Integer> A = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }
        A.sort(Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            if ((i + 1) % 3 != 0) {
                result += A.get(i);
            }
        }
        System.out.println(result);
    }
}