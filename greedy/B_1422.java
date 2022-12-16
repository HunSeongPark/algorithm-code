import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1422 {

    public static void main(String[] args) throws IOException {
        int K;
        int N;
        String[] A;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new String[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            A[i] = br.readLine();
            int num = Integer.parseInt(A[i]);
            if (num > max) {
                max = num;
            }
        }
        Arrays.sort(A, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder sb = new StringBuilder();
        boolean maxRepeat = false;
        for (int i = 0; i < K; i++) {
            if (Integer.parseInt(A[i]) == max && !maxRepeat) {
                for (int j = 0; j <= N - K; j++) {
                    sb.append(A[i]);
                }
                maxRepeat = true;
            } else {
                sb.append(A[i]);
            }
        }
        System.out.println(sb);
        br.close();
    }
}