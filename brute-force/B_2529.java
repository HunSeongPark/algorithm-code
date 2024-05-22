import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2529 {

    static int k;
    static char[] eq;
    static long min = Long.MAX_VALUE; // 10자리 수 > int 범위
    static long max = 0;
    static String minStr = "";
    static String maxStr = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        eq = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            eq[i] = st.nextToken().charAt(0);
        }
        for (int n = 0; n <= 9; n++) {
            ArrayList<Integer> arr = new ArrayList<>(); // 결과 담을 list
            arr.add(n); // 0 ~ 9까지 맨 앞에 넣음
            dfs(n, 0, arr); // 브루트포스
        }
        System.out.println(maxStr + "\n" + minStr);
    }

    public static void dfs(int n, int idx, ArrayList<Integer> arr) {
        if (idx == k) { // k + 1개 숫자 모두 담김
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num);
            }
            long result = Long.parseLong(sb.toString()); // long 타입으로 결과 변환
            min = Math.min(min, result);
            minStr = min == result ? sb.toString() : minStr; // 맨 앞이 0일 경우 고려
            max = Math.max(max, result);
            maxStr = max == result ? sb.toString() : maxStr;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (arr.contains(i)) continue; // 숫자가 이미 사용된 경우 스킵
            if (eq[idx] == '>' && n < i) continue; // 부등호 비교
            if (eq[idx] == '<' && n > i) continue;
            arr.add(i); // 조건 만족 시 결과 배열에 추가
            dfs(i, idx + 1, arr); // 다음 depth 탐색
            arr.remove(arr.size() - 1); // dfs 종료 후 결과에서 제거
        }
    }
}