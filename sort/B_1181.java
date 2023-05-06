import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        StringBuilder answer = new StringBuilder();
        String prev = arr[0];
        answer.append(arr[0]).append("\n");
        for (int i = 1; i < N; i++) {
            if (prev.equals(arr[i])) continue;
            prev = arr[i];
            answer.append(arr[i]).append("\n");
        }
        System.out.println(answer);
    }
}