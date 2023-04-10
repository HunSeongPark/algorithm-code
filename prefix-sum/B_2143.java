import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_2143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) arr[i] = Integer.parseInt(st.nextToken());
            else arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            for (int j = 0; j < i; j++) {
                int prefix = arr[i] - arr[j];
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            if (i == 0) arr[i] = Integer.parseInt(st.nextToken());
            else arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        for (int i = 0; i < M; i++) {
            int diff = T - arr[i];
            if (map.containsKey(diff)) answer += map.get(diff);
            for (int j = 0; j < i; j++) {
                int prefix = arr[i] - arr[j];
                diff = T - prefix;
                if (map.containsKey(diff)) {
                    answer += map.get(diff);
                }
            }
        }
        System.out.println(answer);
    }
}