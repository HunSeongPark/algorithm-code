import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_15787 {

    static int[] arr;
    static Set<Integer> result = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] |= (1 << (x - 1));
            } else if (t == 2) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] &= ~(1 << (x - 1));
            } else if (t == 3) {
                arr[i] &= ~(1 << 19);
                arr[i] <<= 1;
            } else {
                arr[i] &= ~1;
                arr[i] >>= 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            result.add(arr[i]);
        }
        System.out.println(result.size());
    }
}