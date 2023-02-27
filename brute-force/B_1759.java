import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_1759 {

    static int L, C;
    static char[] arr;
    static boolean[] visited;
    static int cCount = 0; // 자음
    static int vCount = 0; // 모음
    static List<Character> consonant = Arrays.asList('a', 'e', 'i', 'o', 'u');
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, 0, "");
        System.out.println(answer);
    }

    public static void dfs(int start, int count, String result) {
        if (count == L) {
            if (cCount >= 1 && vCount >= 2) {
                answer.append(result).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                boolean isConsonant = consonant.contains(arr[i]);
                if (isConsonant) {
                    cCount++;
                } else {
                    vCount++;
                }
                dfs(i + 1, count + 1, result + arr[i]);
                visited[i] = false;
                if (isConsonant) {
                    cCount--;
                } else {
                    vCount--;
                }
            }
        }
    }
}