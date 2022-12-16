import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11728 {

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int[] A;
        int[] B;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        int b = 0;
        while(true) {
            if (a == A.length) {
                while (b < B.length) {
                    sb.append(B[b++]).append(" ");
                }
                break;
            } else if (b == B.length) {
                while (a < A.length) {
                    sb.append(A[a++]).append(" ");
                }
                break;
            } else {
                if (A[a] <= B[b]) {
                    sb.append(A[a++]).append(" ");
                } else {
                    sb.append(B[b++]).append(" ");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}