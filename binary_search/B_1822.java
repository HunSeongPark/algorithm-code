import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1822 {

    public static void main(String[] args) throws IOException {
        int a, b;
        int[] A;
        int[] B;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        A = new int[a];
        B = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            int num = A[i];
            int start = 0;
            int end = b - 1;
            boolean isFind = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (B[mid] == num) {
                    isFind = true;
                    break;
                } else if (B[mid] > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (!isFind) {
                result.add(num);
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}