import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            idx = Math.max(arr[i].length(), idx);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length()) {
                    answer.append(arr[j].charAt(i));
                }
            }
        }
        System.out.println(answer);
    }
}