import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11399 {

    static int N;
    static int[] P;
    static int[] S;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i < N; i++) {
            int key = P[i];
            int j = i - 1;
            while (j >= 0 && P[j] > key) {
                P[j + 1] = P[j];
                j--;
            }
            P[j + 1] = key;
        }
        S[0] = P[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + P[i];
        }
        int sum = 0;
        for (int i : S) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[N];
        S = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

}