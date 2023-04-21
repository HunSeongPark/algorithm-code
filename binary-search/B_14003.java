import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14003
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        int[] DP = new int[N];
        int[] index = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = box[0];
        int LIS = 1;
        index[0] = 0;
        for (int i = 1; i < N; i++) {
            int find = binarySearch(DP, box[i], 0, LIS, LIS + 1);
            if (find == -1) {
                DP[LIS] = box[i];
                index[i] = LIS++;
            } else {
                DP[find] = box[i];
                index[i] = find;
            }
        }
        System.out.println(LIS);
        int[] answer = new int[LIS];
        int idx = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (index[i] + 1 == LIS) {
                answer[idx++] = box[i];
                LIS--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx - 1; i >= 0; i--) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] DP, int target, int start, int end, int size) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= DP[mid]) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start == size) {
            return -1;
        }
        return result;
    }
}