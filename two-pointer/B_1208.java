import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1208 {

    static int N, S;
    static long[] arr;
    static ArrayList<Long> A = new ArrayList<>();
    static ArrayList<Long> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        findSum(A, 0, 0, N / 2);
        findSum(B, 0, N / 2, N);
        Collections.sort(A);
        Collections.sort(B);
        long answer = 0;
        int a = 0;
        int b = B.size() - 1;
        while (a < A.size() && b >= 0) {
            long sum = A.get(a) + B.get(b);
            if (sum == S) {
                long correctA = A.get(a);
                long aCount = 0;
                while (a < A.size() && A.get(a) == correctA) {
                    a++;
                    aCount++;
                }
                long correctB = B.get(b);
                long bCount = 0;
                while (b >= 0 && B.get(b) == correctB) {
                    b--;
                    bCount++;
                }
                answer += aCount * bCount;
            } else if (sum < S) {
                a++;
            } else {
                b--;
            }
        }
        System.out.println(S == 0 ? answer - 1 : answer);
    }

    public static void findSum(ArrayList<Long> result, long sum, int idx, int end) {
        if (idx == end) {
            result.add(sum);
            return;
        }
        findSum(result, sum + arr[idx], idx + 1, end);
        findSum(result, sum, idx + 1, end);
    }
}