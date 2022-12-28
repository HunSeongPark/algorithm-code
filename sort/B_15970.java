import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_15970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            A[color].add(dist);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i].size() > 1) {
                for (int j = 0; j < A[i].size(); j++) {
                    if (j == 0) {
                        result += A[i].get(j + 1) - A[i].get(j);
                    } else if (j == A[i].size() - 1) {
                        result += A[i].get(j) - A[i].get(j - 1);
                    } else {
                        result += Math.min(A[i].get(j + 1) - A[i].get(j), A[i].get(j) - A[i].get(j - 1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}