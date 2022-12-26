import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17387 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] X = new long[4];
        long[] Y = new long[4];
        for (int i = 0; i < 4; i+=2) {
            st = new StringTokenizer(br.readLine());
            X[i] = Long.parseLong(st.nextToken());
            Y[i] = Long.parseLong(st.nextToken());
            X[i + 1] = Long.parseLong(st.nextToken());
            Y[i + 1] = Long.parseLong(st.nextToken());
        }
        long ccw1 = CCW(X[0], Y[0], X[1], Y[1], X[2], Y[2]);
        long ccw2 = CCW(X[0], Y[0], X[1], Y[1], X[3], Y[3]);
        long ccw3 = CCW(X[2], Y[2], X[3], Y[3], X[0], Y[0]);
        long ccw4 = CCW(X[2], Y[2], X[3], Y[3], X[1], Y[1]);

        if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
            if (isOverlap(X[0], Y[0], X[1], Y[1], X[2], Y[2], X[3], Y[3])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static long CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (ccw > 0) {
            return 1;
        } else if (ccw < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private static boolean isOverlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        return Math.max(x1, x2) >= Math.min(x3, x4) && Math.max(x3, x4) >= Math.min(x1, x2)
                && Math.max(y1, y2) >= Math.min(y3, y4) && Math.max(y3, y4) >= Math.min(y1, y2);
    }
}
