import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12738
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        int[] DP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = box[0];
        int LIS = 1;
        for (int i = 1; i < N; i++) {
            int idx = binarySearch(DP, box[i], 0, LIS, LIS + 1);
            if (idx == -1) {
                DP[LIS++] = box[i];
            } else {
                DP[idx] = box[i];
            }
        }
        System.out.println(LIS);
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