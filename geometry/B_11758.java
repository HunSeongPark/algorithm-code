import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] X = new int[3];
        int[] Y = new int[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        int ccw = (X[0] * Y[1] + X[1] * Y[2] + X[2] * Y[0]) - (X[1] * Y[0] + X[2] * Y[1] + X[0] * Y[2]);
        if (ccw < 0) {
            System.out.println(-1);
        } else if (ccw == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
