import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] errors = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            errors[Integer.parseInt(st.nextToken())] = true;
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        if (X <= Y) {
            System.out.println(M - Y);
            return;
        }
        int errCount = 0;
        for (int i = 1; i <= X; i++) {
            if (errors[i]) errCount++;
        }
        int min = Math.max(Y, errCount);
        int L = 1;
        for (int R = X + 1; R <= N; R++) {
            if (min == Y) break;
            if (errors[L++]) errCount--;
            if (errors[R]) errCount++;
            min = Math.min(min, Math.max(Y, errCount));
        }
        System.out.println(M - min);
    }
}
