import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                result.add(s);
            }
        }
        Collections.sort(result);
        StringBuilder answer = new StringBuilder();
        answer.append(result.size()).append("\n");
        for (String s : result) {
            answer.append(s).append("\n");
        }
        System.out.println(answer);
    }
}