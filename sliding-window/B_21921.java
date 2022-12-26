import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21921 {

    public static void main(String[] args) throws IOException {
        int N;
        int X;
        int[] A;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        int a = 0;
        int b = X;
        int max = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (i < X) {
                max += A[i];
            }
        }
        int cur = max;
        while (b < N) {
            cur = cur + A[b] - A[a];
            if (cur > max) {
                max = cur;
                count = 1;
            } else if (cur == max) {
                count++;
            }
            a++;
            b++;
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}